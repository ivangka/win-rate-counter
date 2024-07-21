package ivangka.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Class to handle reading statistics from a file.
 */
public class ReadStatistics {

    /**
     * Method to read statistics from a binary file.
     *
     * @return the Statistics object read from the file, or a new Statistics object if the file is empty
     */
    public static Statistics readStatistics() {

        // check if the file is empty
        if (new File("statistics.bin").length() == 0)
            return new Statistics();

        try {
            FileInputStream fis = new FileInputStream("statistics.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Statistics tempStatistics = (Statistics) ois.readObject();
            ois.close();
            return tempStatistics;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
