import java.util.regex.Pattern;

// Bogie class (keep if already present in your file)
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class train_consist_mngmt_app {

    // Validate Train ID (TRN-1234)
    public static boolean isValidTrainID(String trainID) {
        return Pattern.matches("TRN-\\d{4}", trainID);
    }

    // Validate Cargo Code (PET-AB)
    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String trainID = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("\nTrain ID: " + trainID + " -> " +
                (isValidTrainID(trainID) ? "Valid" : "Invalid"));

        System.out.println("Cargo Code: " + cargoCode + " -> " +
                (isValidCargoCode(cargoCode) ? "Valid" : "Invalid"));
    }
}