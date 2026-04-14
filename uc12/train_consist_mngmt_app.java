import java.util.*;

// Goods Bogie class
class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class train_consist_mngmt_app {

    // Safety validation method
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean safe = isTrainSafe(bogies);

        System.out.println("\nTrain Safety Status: " + (safe ? "SAFE" : "UNSAFE"));
    }
}