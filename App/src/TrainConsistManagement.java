import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagement {

    public static void main(String[] args) {

        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 78);
        bogieCapacity.put("First Class", 24);

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " Capacity: " + entry.getValue());
        }
    }
}