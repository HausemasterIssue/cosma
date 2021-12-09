package cope.cosma.listener;

import cope.cosma.annotation.Cancelable;

public class Event {
    protected boolean cancelable = false;
    private boolean canceled = false;

    public Event() {
        cancelable = getClass().isAnnotationPresent(Cancelable.class);
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public boolean isCanceled() {
        return cancelable && canceled;
    }

    public void setCanceled(boolean canceled) {
        if (!cancelable) {
            return;
        }

        this.canceled = canceled;
    }
}
