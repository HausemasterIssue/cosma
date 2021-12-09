package cope.cosma.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used above the Event class, to mark the event as cancelable.
 * @author aesthetical
 * @since 8/12/21
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Cancelable {
}
