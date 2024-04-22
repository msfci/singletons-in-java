package singleton;

/**
 * Thread safe singleton with lazy initialization.
 * Pros: Lazy initialization in case of large object size will be good for performance
 * Cons: Not safe with deserialization.
 *
 * @author Mostafa Saied
 */
public class SingletonLazy {

    private static SingletonLazy INSTANCE = null;

    private SingletonLazy() {
    }

    public static synchronized SingletonLazy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLazy();
        }

        return INSTANCE;
    }

}