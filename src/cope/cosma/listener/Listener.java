package cope.cosma.listener;

import java.lang.reflect.Method;

/**
 * Listener object. This is only to be used within the EventBus
 * @author aesthetical
 * @since 8/12/21
 */
public class Listener {
    public final Object object;
    public final Class<? extends Event> clazz;
    public final Method method;
    public final boolean receiveCancelled;
    public final int priority;

    public Listener(Object object, Class<? extends Event> clazz, Method method, boolean receiveCancelled, int priority) {
        this.object = object;
        this.clazz = clazz;
        this.method = method;
        this.receiveCancelled = receiveCancelled;
        this.priority = priority;
    }
}
