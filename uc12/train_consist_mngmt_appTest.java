import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class train_consist_mngmt_appTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new GoodsBogie("Open", "Coal"));

        assertTrue(train_consist_mngmt_app.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Coal"));

        assertFalse(train_consist_mngmt_app.isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Open", "Coal"));
        list.add(new GoodsBogie("Box", "Grain"));

        assertTrue(train_consist_mngmt_app.isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new GoodsBogie("Cylindrical", "Coal")); // violation

        assertFalse(train_consist_mngmt_app.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(train_consist_mngmt_app.isTrainSafe(list));
    }
}