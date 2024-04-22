import singleton.SingletonFieldSerializableWithSolution;

import java.io.*;

/**
 * @author Mostafa Saied
 */

public class SerializationSolutionDemo {

    public static void main(String[] args) {
        SingletonFieldSerializableWithSolution singletonFieldSerializableWithSolution = SingletonFieldSerializableWithSolution.INSTANCE;
        singletonFieldSerializableWithSolution.setValue(1);

        // Step 1 -> Serialize
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("out.ser");
                ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(singletonFieldSerializableWithSolution);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Step 2 -> Change value
        singletonFieldSerializableWithSolution.setValue(2);

        // Step 3 -> Deserialize
        SingletonFieldSerializableWithSolution singletonFieldSerializableWithSolution2;
        try (
                FileInputStream fileInputStream = new FileInputStream("out.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            singletonFieldSerializableWithSolution2 = (SingletonFieldSerializableWithSolution) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Singleton obj 1 value -> " + singletonFieldSerializableWithSolution.getValue());
        System.out.println("Singleton obj 2 value -> " + singletonFieldSerializableWithSolution2.getValue());

    }
}
