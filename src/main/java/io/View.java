package io;

import logic.Tree;

import java.util.*;

public class View {
    public static void menu() {
        Tree tree=new Tree();
        Scanner read=new Scanner(System.in);
        int option=1;
        while(option!=0){
            System.out.println("""
                1. add element
                2. remove element
                3. show tree
                4. show root
                5.add 10^5 elements
                6.add 10^6 elements
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
                    System.out.println(tree.remove(element));
                    break;
                case 3:
                    System.out.println(tree.show());
                    break;
                case 4:
                    System.out.println(tree.showRoot());
                    break;
                case 5:
                    System.out.println("час потрібний для додавання 10^5 елементів: "+
                            calculateTimeForAddNElements(10000, tree)+" мілісекунд");
                    break;
                case 6:
                    System.out.println("час потрібний для додавання 10^6 елементів: "+
                            calculateTimeForAddNElements(100000, tree)+" мілісекунд");
                    break;
            }
        }
    }

    private static long calculateTimeForAddNElements(int n,Tree tree) {
        Random rand=new Random();
        long start=System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int t=rand.nextInt(10000000);
            tree.add(t);
        }
        long end=System.currentTimeMillis();
        return end-start;
    }
}
