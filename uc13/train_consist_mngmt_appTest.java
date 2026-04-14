import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class train_consist_mngmt_appTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("Luxury", 80));
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result =
                train_consist_mngmt_app.filterUsingLoop(createSampleBogies());

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result =
                train_consist_mngmt_app.filterUsingStream(createSampleBogies());

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult =
                train_consist_mngmt_app.filterUsingLoop(createSampleBogies());

        List<Bogie> streamResult =
                train_consist_mngmt_app.filterUsingStream(createSampleBogies());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = createSampleBogies();

        long start = System.nanoTime();
        train_consist_mngmt_app.filterUsingStream(list);
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("B" + i, i % 100));
        }

        List<Bogie> result =
                train_consist_mngmt_app.filterUsingStream(list);

        assertNotNull(result);
    }
}