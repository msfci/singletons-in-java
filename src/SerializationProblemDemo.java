import singleton.SingletonFieldSerializable;

import java.io.*;

/**
 * @author Mostafa Saied
 */

public class SerializationProblemDemo {

    public static void main(String[] args) {
        SingletonFieldSerializable singletonFieldSerializable = SingletonFieldSerializable.INSTANCE;
        singletonFieldSerializable.setValue(1);

        // Step 1 -> Serialize
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("out.ser");
                ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(singletonFieldSerializable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Step 2 -> Change value
        singletonFieldSerializable.setValue(2);

        // Step 3 -> Deserialize
        SingletonFieldSerializable singletonFieldSerializable2;
        try (
                FileInputStream fileInputStream = new FileInputStream("out.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            singletonFieldSerializable2 = (SingletonFieldSerializable) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Singleton obj 1 value -> " + singletonFieldSerializable.getValue());
        System.out.println("Singleton obj 2 value -> " + singletonFieldSerializable2.getValue());

    }
}
