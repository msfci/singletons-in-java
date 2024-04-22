package singleton;

/**
 * @author Mostafa Saied
 *
 *  Singleton with field
 *
 *  Cons: Not safe with deserialization.
 */

public class SingletonField {
    private int value;
    public static final SingletonField INSTANCE = new SingletonField();

    private SingletonField() {}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
