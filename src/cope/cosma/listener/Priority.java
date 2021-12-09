package cope.cosma.listener;

/**
 * The event priority. Sorted from least -> highest value.
 * Hence Priority.HIGHEST is equal to 0.
 *
 * @author aesthetical
 * @since 8/12/21
 */
public interface Priority {
    int DEFAULT = Integer.MAX_VALUE;
    int LOW = 30;
    int MEDIUM = 20;
    int HIGH = 10;
    int HIGHEST = 0;
}
