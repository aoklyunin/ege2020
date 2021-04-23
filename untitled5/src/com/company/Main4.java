package com.company;

public class Main4 {

    public static void main(String[] args) {
        int l = 61;
        int[][] arr = new int[2 * l][2 * l];
        int[][] arr2 = new int[2 * l][2 * l];
        int[][] arr3 = new int[2 * l][2 * l];
        for (int i = 0; i < 2 * l; i++) {
            for (int j = 0; j < 2 * l; j++) {
                arr[i][j] = 0;
                arr2[i][j] = 0;
            }
        }

        for (int i = l; i < 2 * l; i++)
            for (int j = 1; j < l; j++) {
                arr[i][j] = 1;
                arr[j][i] = 1;
            }

        for (int i = 2 * l - 1; i >= 1; i--) {
            for (int j = 2 * l - 1; j >= 1; j--) {
                if (arr[i][j] == 1) {
                    arr2[i][j - 1] = 2;
                    arr2[i - 1][j] = 2;
                    if (i % 2 == 0)
                        arr2[i / 2][j] = 2;
                    if (j % 2 == 0)
                        arr2[i][j / 2] = 2;
                }
            }
        }
        for (int i = 2 * l - 1; i >= 1; i--) {
            for (int j = 2 * l - 1; j >= 1; j--) {
                if (arr2[i][j] == 2) {
                    arr3[i][j - 1] = 3;
                    arr3[i - 1][j] = 3;
                    if (i % 2 == 0) {
                        arr3[i / 2][j] = 3;
                    }
                    if (j % 2 == 0)
                        arr3[i][j / 2] = 3;
                }
            }
        }

//        for (int i = 0; i < l * 2; i++) {
//            for (int j = 0; j < l * 2; j++) {
////                if (arr[i][j]==1)
////                    System.out.println("|||||");
//                System.out.print(arr3[i][j] + " ");
//            }
//            System.out.println();
//               }

        for (int S = 1; S <= 50; S++) {
            //System.out.println(arr2[10][S] + " " + arr2[S][10]);
            if (arr3[10][S] == 3) {
                System.out.println(">" + S);
                break;
            }
        }


    }
}
