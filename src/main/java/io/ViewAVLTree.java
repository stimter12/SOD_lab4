package io;

import logic.AVLTree;

import java.util.*;

public class ViewAVLTree {
    public static void menu() {
        AVLTree tree=new AVLTree();
        Scanner read=new Scanner(System.in);
        int option=1;
        while(option!=0){
            System.out.println("""
                1. add element
                2. remove element
                3. show tree
                4. show root
                5. show height
                6. add 10 elements
                0. Exit
                """);
            option=read.nextInt();
            int element;
            switch(option) {
                case 1:
                    System.out.println("Enter element to add:");
                    element = read.nextInt();
                    tree.add(element);
                    break;
                case 2:
                    System.out.println("Enter element to remove:");
                    element = read.nextInt();
                    tree.remove(element);
                    break;
                case 3:
                    System.out.println(tree.show());
                    break;
                case 4:
                    System.out.println(tree.showRoot());
                    break;
                case 5:
                    System.out.println(tree.showHeight());
                    break;
                case 6:
                    add10Elements(tree);
                    break;
            }
        }
    }
    private static void add10Elements(AVLTree tree) {
        Random rand=new Random();
        for (int i = 0; i < 10; i++) {
            int t=rand.nextInt(1000);
            tree.add(t);
        }
    }
}