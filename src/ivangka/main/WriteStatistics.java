package ivangka.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteStatistics {
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

    public static void clearStatistics() {
        File file = new File("statistics.bin");
        if (file.exists()) {
            file.delete();
            System.out.println("The file has been successfully cleared.");
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
