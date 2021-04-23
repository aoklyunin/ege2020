package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main3 {
    static int max = 0;
    static int[][] vals;

    public static void test(int pos, int size, int sum) {
        if (pos == size) {
            if (sum % 4 == 0 && sum > max)
                max = sum;
        } else {
            test(pos + 1, size, sum + vals[pos][0] + vals[pos][1]);
            test(pos + 1, size, sum + vals[pos][0] + vals[pos][2]);
            test(pos + 1, size, sum + vals[pos][2] + vals[pos][1]);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // write your code here
        File file = new File("27-33a.txt");
        try {
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();
            vals = new int[n][3];
            for (int i = 0; i < n; i++) {
                vals[i][0] = scanner.nextInt();
                vals[i][1] = scanner.nextInt();
                vals[i][2] = scanner.nextInt();
            }
            test(0, n, 0);
            System.out.println(max);
            System.out.println(System.currentTimeMillis()-start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
