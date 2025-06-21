import static org.junit.Assert.assertEquals;

// import java.lang.invoke.ClassSpecializer.Factory;

import org.junit.Test;

public class UnitTest {

    @Test
    public void testNewAircraft() throws InvalidScenario {
        AircraftFactory factory = AircraftFactory.getInstance();
        Coordinates coord = new Coordinates(1, 1, 1);

        Flyable baloon = factory.newAircraft("Baloon", "B1", coord);
        assertEquals("Baloon#B1(0)", baloon.toString());
    }

}