import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class train_consist_mngmt_appTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(train_consist_mngmt_app.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(train_consist_mngmt_app.isValidTrainID("TRAIN12"));
        assertFalse(train_consist_mngmt_app.isValidTrainID("TRN12A"));
        assertFalse(train_consist_mngmt_app.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(train_consist_mngmt_app.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(train_consist_mngmt_app.isValidCargoCode("PET-ab"));
        assertFalse(train_consist_mngmt_app.isValidCargoCode("PET123"));
        assertFalse(train_consist_mngmt_app.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(train_consist_mngmt_app.isValidTrainID("TRN-123"));
        assertFalse(train_consist_mngmt_app.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(train_consist_mngmt_app.isValidCargoCode("PET-Ab"));
        assertFalse(train_consist_mngmt_app.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(train_consist_mngmt_app.isValidTrainID(""));
        assertFalse(train_consist_mngmt_app.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(train_consist_mngmt_app.isValidTrainID("TRN-1234X"));
        assertFalse(train_consist_mngmt_app.isValidCargoCode("PET-ABC"));
    }
}