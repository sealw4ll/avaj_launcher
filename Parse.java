import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// import java.io.FileNotFoundException;
import java.io.IOException;

public class Parse {
    public static void parseAircraft(String line, WeatherTower tower) throws InvalidScenario {
        String[] aircraft = line.split(" ");

        if (aircraft.length != 5)
            throw new InvalidScenario("Invalid number of arguements in row { " + line + " }");

        int longitude = Integer.parseInt(aircraft[2]);
        int latitude = Integer.parseInt(aircraft[3]);
        int height = Integer.parseInt(aircraft[4]);
        if (longitude < 0 || latitude < 0)
            throw new InvalidScenario("longitude and latitude cant be less than 0");
        if (height < 0 || height > 100)
            throw new InvalidScenario("height has to be between 0-100");

        AircraftFactory.getInstance()
            .newAircraft(aircraft[0], aircraft[1], new Coordinates(longitude, latitude, height))
            .registerTower(tower);
    }

    public static int parseInput(String filename, WeatherTower tower) throws IOException, InvalidScenario{
        FileInputStream fstream = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        int runTime = Integer.parseInt(br.readLine());
        if (runTime < 0) {
            in.close();
            throw new InvalidScenario("Invalid number of times to run");
        }
        while ((strLine = br.readLine()) != null) {
            parseAircraft(strLine, tower);
            // System.out.println(strLine);
        }
        in.close();
        return (runTime);
    }
}
