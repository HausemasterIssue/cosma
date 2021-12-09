package cope.cosma.annotation;

import cope.cosma.listener.Priority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscription {
    int priority() default Priority.DEFAULT;
    boolean receiveCancelled() default false;
}
