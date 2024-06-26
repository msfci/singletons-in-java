package singleton;

/**
 * @author Mostafa Saied
 */

public enum SingletonEnum {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
