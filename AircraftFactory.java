public class AircraftFactory {
    // singleton
    private static AircraftFactory aircraftFactory;
    private AircraftFactory(){}
    public static AircraftFactory getInstance()
    {
        if (aircraftFactory == null)
        aircraftFactory = new AircraftFactory();
        
        return aircraftFactory;
    }

    private static int counter;
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidScenario {
        switch (p_type) {
            case "Baloon":
                return new Baloon(counter++, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(counter++, p_name, p_coordinates);
            case "JetPlane":
                return new Jetplane(counter++, p_name, p_coordinates);
            default:
                throw new InvalidScenario("Invalid Aircraft Type");
        }
    }
}