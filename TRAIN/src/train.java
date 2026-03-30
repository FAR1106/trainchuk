import java.util.*;

public class train {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        ArrayList<String> bogies = new ArrayList<>();

        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println("After adding bogies: " + bogies);

        bogies.remove("AC Chair");

        System.out.println("After removing AC Chair: " + bogies);

        System.out.println("Sleeper exists: " + bogies.contains("Sleeper"));

        System.out.println("Final bogie list: " + bogies);
    }
}