import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class train_consist_mngmt_appTest {

    // Helper method
    private List<Bogie> createSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));
        list.add(new Bogie("First Class", 24));
        return list;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result =
                train_consist_mngmt_app.filterBogiesByCapacity(createSampleBogies(), 60);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result =
                train_consist_mngmt_app.filterBogiesByCapacity(createSampleBogies(), 60);

        assertFalse(result.stream().anyMatch(b -> b.capacity == 60));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result =
                train_consist_mngmt_app.filterBogiesByCapacity(createSampleBogies(), 70);

        assertTrue(result.stream().allMatch(b -> b.capacity > 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 65));
        list.add(new Bogie("First Class", 24));

        List<Bogie> result =
                train_consist_mngmt_app.filterBogiesByCapacity(list, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result =
                train_consist_mngmt_app.filterBogiesByCapacity(createSampleBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result =
                train_consist_mngmt_app.filterBogiesByCapacity(createSampleBogies(), 10);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result =
                train_consist_mngmt_app.filterBogiesByCapacity(new ArrayList<>(), 50);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = createSampleBogies();
        train_consist_mngmt_app.filterBogiesByCapacity(original, 60);

        assertEquals(3, original.size());
    }
}