package com.company;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double a = 1.5;
        int a1 = (int)a;
        int a2 = (int)(a+0.5);

        // write your code here
        File file = new File("24-s1`12.txt");
        try {
            Scanner scanner = new Scanner(file);
            int cnt = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                for (int i = 0; i < s.length() - 2; i++) {
                    if (s.charAt(i) == 'A' && s.charAt(i + 2) == 'R') {
                        cnt++;
                        break;
                    }
                }
                if (s.contains("A.R")) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        } catch (FileNotFoundException e) {
            System.out.println(e+"-ошибка");
        }
    }
}
