import java.util.*;

public class train {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        HashSet<String> ids = new HashSet<>();

        ids.add("BG101");
        ids.add("BG102");
        ids.add("BG101");
        ids.add("BG103");
        ids.add("BG102");

        System.out.println("Unique Bogie IDs: " + ids);
    }
}