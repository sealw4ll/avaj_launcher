import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public static void truncateFile() {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt", false);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String message) {
        try {
            FileWriter myWriter = new FileWriter("simulation.txt", true);
            myWriter.write(message);
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
