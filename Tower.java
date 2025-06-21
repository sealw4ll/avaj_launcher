import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public Tower(){
        observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable){
        observers.add(p_flyable);
        FileHandler.writeToFile("Tower says: " + p_flyable + " registered to weather tower.\n");
    }

    public void unregister(Flyable p_flyable){
        observers.remove(p_flyable);
        FileHandler.writeToFile("Tower says: " + p_flyable + " unregistered to weather tower.\n");
    }

    protected void conditionChanged(){
        List<Flyable> observersCopy = new ArrayList<>(observers);
        for (Flyable flyable : observersCopy) {
            flyable.updateConditions();
        }
    }
}
