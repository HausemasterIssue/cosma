package cope.cosma.annotation;

import cope.cosma.listener.Priority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used above a method, marking the method as an event handler
 * @author aesthetical
 * @since 8/12/21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscription {
    int priority() default Priority.DEFAULT;
    boolean receiveCancelled() default false;
}
