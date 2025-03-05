import java.util.Random;

public class WeatherProvider {
    //singleton
    private static WeatherProvider weatherProvider;
    private int seed;
    private WeatherProvider(){
        seed = new Random().nextInt(2000);
    }
    public static WeatherProvider getInstance()
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
 
        return weatherProvider;
    }

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[(seed + p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight()) % 4];
    }
}
