package com.company;

import java.util.ArrayList;

public class Main6 {

    public static void main(String[] args) {
        int[][] win = new int[500][500];
        for (int i = 200; i >= 0; i--)
            for (int j = 200; j >= 0; j--)
                win[i][j] = -1;
        for (int i = 200; i >= 0; i--)
            for (int j = 200; j >= 0; j--)
                if (i + j < 61)
                    win[i][j] = -Math.min(win[i + 1][j], Math.min(win[i][j + 1], Math.min(win[i * 2][j], win[i][j * 2])));

        int[][] steps = new int[500][500];
        for (int i = 200; i >= 0; i--)
            for (int j = 200; j >= 0; j--)
                if (i + j < 61) {
                    if (win[i][j] == -1)
                        steps[i][j] = Math.max(steps[i + 1][j], Math.max(steps[i][j + 1], Math.max(steps[i * 2][j], steps[i][j * 2])));
                    else {
                        steps[i][j] = 10000000;
                        if (win[i + 1][j] == -1) steps[i][j] = Math.min(steps[i][j], steps[i + 1][j]);
                        if (win[i][j + 1] == -1) steps[i][j] = Math.min(steps[i][j], steps[i][j + 1]);
                        if (win[i * 2][j] == -1) steps[i][j] = Math.min(steps[i][j], steps[i * 2][j]);
                        if (win[i][j * 2] == -1) steps[i][j] = Math.min(steps[i][j], steps[i][j * 2]);
                        steps[i][j] += 1;
                    }
                }
        // 20
        ArrayList<Integer> ans = new ArrayList<>();
        for (int s = 1; s <= 50; s++)
            if (steps[10][s] * win[10][s] == 2)
                ans.add(s);
        for (int i = 0; i < 2; i++)
            System.out.print(ans.get(i) + " ");
        System.out.println();
        // 21
        int cnt = 0;
        for (int s = 1; s <= 50; s++)
            if (steps[10][s] * win[10][s] == -2)
                cnt++;
        System.out.println(cnt);
    }
}
