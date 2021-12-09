package cope.cosma.listener;

import cope.cosma.annotation.Cancelable;

public class Event {
    protected boolean cancelable = false;
    private boolean canceled = false;

    public Event() {
        if (getClass().isAnnotationPresent(Cancelable.class)) {
            cancelable = true;
        }
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
