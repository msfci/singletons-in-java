package singleton;

/**
 * @author Mostafa Saied
 *
 * Singleton with factory method
 *
 * Pros: Can be easily switch to non-singleton without changing the API by changing the impl of factory method
 * Cons:
 *      - Should contain private constructor
 *      - Not safe with deserialization.
 * @author Mostafa Saied
 */

public class SingletonFactory {
    private static final SingletonFactory INSTANCE = new SingletonFactory();

    public SingletonFactory getInstance() {
        return INSTANCE;
    }
}
