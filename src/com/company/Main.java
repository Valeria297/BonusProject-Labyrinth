package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    private static char[][][] pathArray;

    public static void main(String[] args) throws IOException {
        int h = 0;
        int m = 0;
        int n = 0;

        try (
                BufferedReader buffReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("C:\\Users\\ольга\\IdeaProjects\\BonusProject\\src\\com\\company\\INPUT.TXT"),
                                StandardCharsets.UTF_8
                        )
                )
        ) {
            int[] ints = Arrays.stream(buffReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            h = ints[0];
            m = ints[1];
            n = ints[2];
            pathArray = new char[h][m][n];

            String line;
            while ((line = buffReader.readLine()) != null) {
                for (int b = 0; b < h; b++) {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            char[] lineChar = line.toCharArray();
                            for (int k = 0; k < lineChar.length; k++) {
                                if (!line.equals(" ")) {
                                    pathArray[b][i][j] = lineChar[k];
                                } else {
                                    buffReader.readLine();
                                }
                            }
                        }
                    }
                }
            }
            buffReader.close();
        } catch (IOException e) {
        }

        System.out.println(Arrays.deepToString(pathArray));

       /* Algorithm algorithm = new Algorithm();
        algorithm.algorithmOfPassing(pathArray);

        int timeCount = algorithm.getCountSteps() * 5;
        System.out.println(timeCount);*/
    }

}
