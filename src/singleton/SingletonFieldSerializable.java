package singleton;

import java.io.Serializable;

/**
 * @author Mostafa Saied
 */

public class SingletonFieldSerializable implements Serializable {
    private int value;
    public static final SingletonFieldSerializable INSTANCE = new SingletonFieldSerializable();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
