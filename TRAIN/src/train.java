import java.util.*;

public class train {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        LinkedList<String> consist = new LinkedList<>();

        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        consist.add(2, "Pantry");

        consist.removeFirst();
        consist.removeLast();

        System.out.println("Final Train Consist: " + consist);
    }
}