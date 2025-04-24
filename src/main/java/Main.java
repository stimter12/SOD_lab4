import io.ViewAVLTree;
import io.ViewStringTree;
import io.ViewTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("""
                1. Create int tree
                2. Create AVL tree
                3. Create string tree
                """);
        Scanner read = new Scanner(System.in);
        String option = read.next();
        switch (option) {
            case "1" -> ViewTree.menu();
            case "2" -> ViewAVLTree.menu();
            case "3" -> ViewStringTree.menu();
            default -> System.out.println("Invalid option");
        }
    }
}
