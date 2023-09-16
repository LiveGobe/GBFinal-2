import java.util.*;
import java.io.*;

public class Toy {
    String id;
    String name;
    int frequency;

    public Toy(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<Toy> toys = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter toy id:");
            String id = scanner.nextLine();
            System.out.println("Enter toy name:");
            String name = scanner.nextLine();
            System.out.println("Enter toy frequency:");
            int frequency = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            Toy toy = new Toy(id, name, frequency);
            toys.add(toy);
        }

        File file = new File("output.txt");
        FileWriter writer = new FileWriter(file);

        Random rand = new Random();
        int totalFrequency = toys.stream().mapToInt(t -> t.frequency).sum();

        for (int i = 0; i < 10; i++) {
            int index = -1;
            for(int r = rand.nextInt(totalFrequency); r >= 0; r -= toys.get(++index).frequency);
            Toy toy = toys.get(index);

            writer.write("ID: " + toy.id + ", Name: " + toy.name + ", Frequency: " + toy.frequency + "\n");
        }

        writer.close();
        scanner.close();
    }
}