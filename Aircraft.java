import java.lang.reflect.InaccessibleObjectException;

public class Aircraft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinate;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinate = p_coordinates;
    }

    @Override
    public void updateConditions() {
        throw new InaccessibleObjectException("Base class condition called instead of derived class");
    }

    @Override
    public String toString() {
        return getClass() + "#" + name + "(" + id + ") "; 
    }
}
