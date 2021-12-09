package fuck.you.cosma;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EventBus {
    private final Map<Object, ArrayList<Listener>> listeners = new ConcurrentHashMap<>();
    private final Consumer<Runnable> consumer = Runnable::run;

    public void subscribe(Object object) {
        if (object == null || listeners.containsKey(object)) {
            return;
        }

        ArrayList<Listener> members = new ArrayList<>();

        for (Method method : object.getClass().getDeclaredMethods()) {
            method.setAccessible(true);

            if (method.isAnnotationPresent(Subscription.class) && method.getParameterCount() == 1 && Event.class.isAssignableFrom(method.getParameterTypes()[0])) {
                Subscription sub = method.getDeclaredAnnotation(Subscription.class);
                members.add(new Listener(object, (Class<? extends Event>) method.getParameterTypes()[0], method, sub.receiveCancelled(), sub.priority()));
            }
        }

        members.sort(Comparator.comparingInt((l) -> l.priority));
        listeners.put(object, members);
    }

    public void unsubscribe(Object object) {
        if (object == null) {
            return;
        }

        listeners.remove(object);
    }

    public void dispatch(Event event) {
        listeners.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt((l) -> l.priority))
                .forEach((listener) -> {
                    if (listener.clazz.isInstance(event)) {
                        if (event.isCanceled() && !listener.receiveCancelled) {
                            return;
                        }

                        consumer.accept(() -> {
                            try {
                                listener.method.invoke(listener.object, event);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                });
    }
}
