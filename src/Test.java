import fuck.you.cosma.EventBus;
import fuck.you.cosma.Priority;
import fuck.you.cosma.Subscription;

public class Test {
    private static EventBus EVENT_BUS = new EventBus();

    public static void main(String[] args) {
        EVENT_BUS.subscribe(new ATestSubscriber());
        EVENT_BUS.subscribe(new BTestSubscriber());

        EVENT_BUS.dispatch(new InitEvent(System.currentTimeMillis()));
    }

    public static class ATestSubscriber {
        @Subscription(priority = Priority.HIGHEST)
        public void onInitEvent(InitEvent event) {
            System.out.println(System.currentTimeMillis() - event.getTime());
            event.setCanceled(true);
        }
    }

    public static class BTestSubscriber {
        @Subscription
        public void onInitEvent(InitEvent event) {
            System.out.println("this should never fire");
        }
    }
}
