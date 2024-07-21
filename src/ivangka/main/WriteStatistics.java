package ivangka.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class to handle writing statistics to a file.
 */
public class WriteStatistics {

    /**
     * Method to write statistics to a binary file.
     *
     * @param statistics the Statistics object to be written to the file
     */
    public static void writeStatistics(Statistics statistics) {

        try {
            FileOutputStream fos = new FileOutputStream("statistics.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(statistics);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to clear the statistics file.
     */
    public static void clearStatistics() {

        File file = new File("statistics.bin");

        // check if the file exists before attempting to delete it
        if (file.exists()) {
            file.delete();
            System.out.println("The file has been successfully cleared.");
        } else {
            System.out.println("The file does not exist.");
        }

    }

}
