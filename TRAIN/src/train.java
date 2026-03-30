import java.util.*;

public class train {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        LinkedHashSet<String> bogies = new LinkedHashSet<>();

        bogies.add("Engine");
        bogies.add("Sleeper");
        bogies.add("Cargo");
        bogies.add("Guard");
        bogies.add("Sleeper");

        System.out.println("Train Formation: " + bogies);
    }
}