import java.util.*;

public class train {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String n, int c) {
            name = n;
            capacity = c;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<Bogie> list = new ArrayList<>();

        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));

        list.sort(Comparator.comparingInt(b -> b.capacity));

        for (Bogie b : list) {
            System.out.println(b.name + " -> " + b.capacity);
        }
    }
}