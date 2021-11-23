package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static char[][][] pathArray;

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("C:\\Users\\ольга\\IdeaProjects\\BonusProject\\src\\com\\company\\INPUT.TXT"));

        int[] ints = Arrays.stream(buffReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = ints[0];
        int m = ints[1];
        int n = ints[2];

        pathArray = new char[h][m][n];

        for (int b = 0; b < h; b++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String line = String.valueOf(buffReader.read());
                    for (int k = 0; k < line.length(); k++) {
                        if (!line.equals(" ")) {
                            pathArray[b][i][j] = line.charAt(k);
                        } else {
                            buffReader.readLine();
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(pathArray));

       /* Algorithm algorithm = new Algorithm();
        algorithm.algorithmOfPassing(pathArray);

        int timeCount = algorithm.getCountSteps() * 5;
        System.out.println(timeCount);*/
    }

}
