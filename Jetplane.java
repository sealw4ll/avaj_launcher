public class Jetplane extends Aircraft{
    public Jetplane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinate);

        int latitude = coordinate.getLatitude();
        int longitude = coordinate.getLongitude();
        int height = coordinate.getHeight();

        String info = "JetPlane#" + name + "(" + id + ")";
        switch (weather) {
            case "SUN":
                latitude += 10;
                height += 2;
                FileHandler.writeToFile(info + ": COMBUSTION!\n");
                break;
            case "RAIN":
                latitude += 5;
                FileHandler.writeToFile(info + ": TITRATION!\n");
                break;
            case "FOG":
                latitude += 1;
                FileHandler.writeToFile(info + ": GAS!\n");
                break;
            case "SNOW":
                height -= 7;
                FileHandler.writeToFile(info + ": FREEZE!\n");
                break;
        }
        if (height > 100)
            height = 100;
        if (height < 0) {
            FileHandler.writeToFile(info + " landing.\n");
            weatherTower.unregister(this);
            return ;
        }
        coordinate = new Coordinates(longitude, latitude, height);
    }
}
