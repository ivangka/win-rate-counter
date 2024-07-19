package ivangka.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadStatistics {
    public static Statistics readStatistics() {
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
