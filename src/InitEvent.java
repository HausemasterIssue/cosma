import fuck.you.cosma.Cancelable;
import fuck.you.cosma.Event;

@Cancelable
public class InitEvent extends Event {
    private final long time;

    public InitEvent(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
