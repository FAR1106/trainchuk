import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class train_consist_mngmt_appTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));
        list.add(new Bogie("First Class", 24));
        return list;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int result = train_consist_mngmt_app.calculateTotalCapacity(createSampleBogies());
        assertEquals(156, result); // 72 + 60 + 24
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int result = train_consist_mngmt_app.calculateTotalCapacity(createSampleBogies());
        assertTrue(result > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));

        int result = train_consist_mngmt_app.calculateTotalCapacity(list);
        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = train_consist_mngmt_app.calculateTotalCapacity(new ArrayList<>());
        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = createSampleBogies();

        int expected = 72 + 60 + 24;
        int result = train_consist_mngmt_app.calculateTotalCapacity(list);

        assertEquals(expected, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int result = train_consist_mngmt_app.calculateTotalCapacity(createSampleBogies());
        assertEquals(156, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = createSampleBogies();
        train_consist_mngmt_app.calculateTotalCapacity(original);

        assertEquals(3, original.size());
    }
}