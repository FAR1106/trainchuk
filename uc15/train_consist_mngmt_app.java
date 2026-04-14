class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie class
class GoodsBogie {
    String type;   // Rectangular, Cylindrical, etc.
    String cargo;  // Coal, Grain, Petroleum, etc.

    GoodsBogie(String type) {
        this.type = type;
    }

    // Safe cargo assignment with try-catch-finally
    public void assignCargo(String cargo) {
        try {
            // Rule: Rectangular bogie cannot carry Petroleum
            if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }

            // Safe assignment
            this.cargo = cargo;
            System.out.println(type + " bogie assigned cargo: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment attempt completed.\n");
        }
    }
}

public class train_consist_mngmt_app {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe
        b1.assignCargo("Petroleum");

        // Unsafe
        b2.assignCargo("Petroleum");

        // Program continues
        b2.assignCargo("Coal");
    }
}