package io;

import logic.StringTree;

import java.util.*;

public class ViewStringTree {
    public static void menu() {
        StringTree tree=new StringTree();
        Scanner read=new Scanner(System.in);
        int option=1;
        while(option!=0){
            System.out.println("""
                1. add element
                2. remove element
                3. show tree
                4. show root
                0. Exit
                """);
            option=read.nextInt();
            String element;
            switch(option) {
                case 1:
                    System.out.println("Enter element to add:");
                    element = read.next();
                    tree.add(element);
                    break;
                case 2:
                    System.out.println("Enter element to remove:");
                    element = read.next();
                    System.out.println(tree.remove(element));
                    break;
                case 3:
                    System.out.println(tree.show());
                    break;
                case 4:
                    System.out.println(tree.showRoot());
                    break;
            }
        }
    }
}

