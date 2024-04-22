package singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Mostafa Saied
 **/

public class SingletonFieldSerializableWithSolution implements Serializable {
    private int value;

    public static final SingletonFieldSerializableWithSolution INSTANCE = new SingletonFieldSerializableWithSolution();

    @Serial
    protected Object readResolve() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
