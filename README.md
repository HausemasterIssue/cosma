# cosma
A fast and lightweight event bus

**Disclaimer**: This was originally meant to be for [Cosmos](https://github.com/momentumdevelopment/cosmos), because Linus thought that the FML Event Bus was an issue, when it wasn't. However, it turns out that this one is wayyyy faster than it, so yeah.

---

## Usage

For example:

```java
import cope.cosma.bus.EventBus;

public class Main {
    private static final EventBus EVENT_BUS = new EventBus();
    
    public static void main(String[] args) {
        // @todo add your code here
    }
}
```

The `EVENT_BUS` field is what we're worried about, here is all of the methods you need to know:

- `subscribe(Ljava/lang/Object)V` - Subscribes an object to the EventBus
- `unsubscribe(Ljava/lang/Object)V` - Removes a subscriber
- `dispatch(Lcope/cosma/listener/Event)V` - Dispatches an event to all subscribers

To create an event, do the following:

```java
import cope.cosma.listener.Event;

// If you want to be able to cancel this event from emitting to other listeners, add a @Cancelable here!
public class MyEvent extends Event {
    private final long time;

    public MyEvent(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
```

Then you can just post the event to the EventBus as follows:

```java
Main.EVENT_BUS.dispatch(new MyEvent(System.currentTimeMillis()));
```

---

## Speed

From dispatching the event to receiving the event, there was a 10-20ms delay on average.

---


<h5 align="center">Sxmurai - 2021</h5>