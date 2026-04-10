import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
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

    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals(80, result.get(0).capacity);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 75),
                new Bogie("First Class", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 75)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        ));

        int originalSize = bogies.size();

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(originalSize, bogies.size());
        assertEquals(1, result.size());
    }
}