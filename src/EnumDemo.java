import singleton.SingletonEnum;

import java.io.*;

/**
 * @author Mostafa Saied
 *
 * Serialization/ Reflection problem solved by default when using enum
 *
 * https://docs.oracle.com/en/java/javase/17/docs/specs/serialization/serial-arch.html#serialization-of-enum-constants
 * @author Mostafa Saied
 */

public class EnumDemo {

    public static void main(String[] args) {

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.setValue(1);

        // Step 1 -> Serialize
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("out.ser");
                ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(singletonEnum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Step 2 -> Change value
        singletonEnum.setValue(2);

        // Step 3 -> Deserialize
        SingletonEnum singletonEnum1;
        try (
                FileInputStream fileInputStream = new FileInputStream("out.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            singletonEnum1 = (SingletonEnum) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Singleton obj 1 value -> " + singletonEnum.getValue());
        System.out.println("Singleton obj 2 value -> " + singletonEnum1.getValue());

    }
}