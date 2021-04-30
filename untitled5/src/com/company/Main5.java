package com.company;


import java.util.ArrayList;

public class Main5 {

    static int max(int... elems) {
        int a = elems[0];
        for (int i = 1; i < elems.length; i++) {
            a = Math.max(a, elems[i]);
        }
        return a;
    }
    static int min(int... elems) {
        int a = elems[0];
        for (int i = 1; i < elems.length; i++) {
            a = Math.min(a, elems[i]);
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] arr = new int[500][500];
        for (int i = 0; i < 500; i++)
            for (int j = 0; j < 500; j++)
                arr[i][j] = -1;

        for (int i = 200; i >= 0; i--) {
            for (int j = 200; j >= 0; j--) {
                arr[i][j] = -min(
                        arr[i + 1][j],
                        arr[i][j + 1],
                        arr[i * 2][j],
                        arr[i][j * 2]
                );
            }
        }

        int[][] steps = new int[500][500];
        for (int i = 0; i < 500; i++)
            for (int j = 0; j < 500; j++)
                steps[i][j] = 0;

        for (int i = 200; i >= 0; i--) {
            for (int j = 200; j >= 0; j--) {
                if (i + j < 61) {
                    if (arr[i][j] == -1)
                        steps[i][j] = max(
                                steps[i + 1][j],
                                steps[i][j + 1],
                                steps[i * 2][j],
                                steps[i][j * 2]
                        );
                    else {
                        steps[i][j] = 1000000;
                        if (arr[i + 1][j] == -1) steps[i][j] = Math.min(steps[i][j], steps[i + 1][j]);
                        if (arr[i][j + 1] == -1) steps[i][j] = Math.min(steps[i][j], steps[i][j + 1]);
                        if (arr[i * 2][j] == -1) steps[i][j] = Math.min(steps[i][j], steps[i * 2][j]);
                        if (arr[i][j * 2] == -1) steps[i][j] = Math.min(steps[i][j], steps[i][j * 2]);
                        steps[i][j] += 1;
                    }
                }
            }
        }
        // 21
        int cnt = 0;
        for (int s = 1; s <= 50; s++) {
            if (steps[10][s] * arr[10][s] == -2)
                cnt++;
        }
        System.out.println(cnt);
        // 20
        ArrayList<Integer> lst = new ArrayList<>();
        for (int s = 1; s <= 50; s++)
            if (steps[10][s] * arr[10][s] == 2)
                lst.add(s);

        for (int i = 0; i < 2; i++) {
            System.out.print(lst.get(i) + " ");
        }
        System.out.println();

    }
}
