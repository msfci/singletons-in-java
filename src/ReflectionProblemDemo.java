import singleton.SingletonField;

import java.lang.reflect.Constructor;

/**
 * @author Mostafa Saied
 * Problem:
 * An advanced user can change the private access modifier of the constructor to anything they want at runtime using reflection.
 * If this happens, our only mechanism for non-instantiability breaks.
 */

public class ReflectionProblemDemo {

    public static void main(String[] args) throws Exception {
        SingletonField singletonField = SingletonField.INSTANCE;

        Constructor<? extends SingletonField> constructor = singletonField.getClass().getDeclaredConstructor();
        constructor.setAccessible(true);

        SingletonField singletonField1 = (SingletonField)constructor.newInstance();

        singletonField.setValue(1);
        singletonField1.setValue(2);

        System.out.println("Singleton obj 1 value -> " + singletonField.getValue());
        System.out.println("Singleton obj 2 value -> " + singletonField1.getValue());

    }
}
