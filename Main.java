// import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{
    public static void main(String[] args){
        try {
            WeatherTower tower = new WeatherTower();
            if (args.length != 2){
                throw new IllegalArgumentException("Invalid number of arguments");
            }
            FileHandler.truncateFile();
            int runTime = Parse.parseInput(args[1], tower);
            for (int i = 0; i < runTime; i++) {
                tower.conditionChanged();
            }
        } catch (IllegalArgumentException | IOException | InvalidScenario e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());
        }
    }
}