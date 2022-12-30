package org.example;

import java.util.*;

public class Main {
    public static void printStars(int space, int stars ){
        String result = "";
        for(int i =0; i < space; i++){
            result += " ";
        }

        for(int j = 0; j < stars; j++){
            result += "*";
        }
        System.out.println(result);

    }


    public static void pyramid(int n){
        int stars = 1;
        int space = 4;

        for(int i = 1;i<=n;i++) {
        printStars(space,stars);
        space--;
        stars++;

        }
    }
    public static void print2(int n2){
        int space2 = 1;
        int stars2 = 4;
        for(int i =1;i<=n2;i++){
            printStars(space2,stars2);
            space2++;
            stars2--;
        }

    }
    public static void main(String[] args) {
        pyramid(5);
        print2(4);
        Map<String,String> a = new HashMap<>();
        Set<String> a = new HashSet<>();
        List<String> a = new ArrayList<>();
    }
}


