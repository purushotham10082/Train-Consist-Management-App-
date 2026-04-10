import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private int totalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        int result = totalCapacity(bogies);

        assertEquals(130, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50)
        );

        int result = totalCapacity(bogies);

        assertEquals(180, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Collections.singletonList(
                new Bogie("Sleeper", 80)
        );

        int result = totalCapacity(bogies);

        assertEquals(80, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int result = totalCapacity(bogies);

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 40),
                new Bogie("AC Chair", 60)
        );

        int result = totalCapacity(bogies);

        assertEquals(100, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 30),
                new Bogie("AC Chair", 40),
                new Bogie("First Class", 50)
        );

        int result = totalCapacity(bogies);

        assertEquals(120, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        ));

        int originalSize = bogies.size();

        int result = totalCapacity(bogies);

        assertEquals(originalSize, bogies.size());
        assertEquals(130, result);
    }
}