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
                1.
                2.
                3.
                4.
                5.додати 10^5 елементів
                6.додати 10^6 елементів
                0. Exit
                """);
            option=read.nextInt();
            switch(option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

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
            int t=rand.nextInt(100);
            tree.add(String.valueOf(t));
        }
        long end=System.currentTimeMillis();
        return end-start;
    }
}
