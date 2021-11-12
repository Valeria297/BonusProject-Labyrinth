package com.company;

public class Algorithm {
    private boolean array[][] = new boolean[3][9];
    private int countSteps = 0;

    public int algorithmOfPassing(char[][] pathArray) {
        char player = '.';

        for (int i = 0; i < pathArray.length; i++) {
            for (int j = 0; j < pathArray[i].length; j++) {
                while (pathArray[i + 1][j] != -1
                        && pathArray[i][j - 1] != -1
                        && pathArray[i][j + 1] != -1) {

                    if (player == 2) {
                        return countSteps;
                    }

                    if (pathArray[i][j] == 1) {
                        player = pathArray[i][j];
                        array[i][j] = true;
                        continue;
                    }

                    if (pathArray[i + 1][j] == 'o'
                            || pathArray[i][j - 1] == 'o'
                            || pathArray[i][j + 1] == 'o') {
                         continue;
                    }

                    if (pathArray[i][j] == '.' && !array[i][j]) {
                        array[i][j] = true;
                        player = pathArray[i][j];
                        countSteps++;
                    }

                    if (pathArray[i + 1][j] == 'o'
                            && pathArray[i + 1][j + 1] == 'o'
                            && pathArray[i + 1][j - 1] == 'o'
                            && !array[i][j]) {
                        array[i][j] = true;
                        player = pathArray[i + 1][j];
                        countSteps++;
                    }

                }
            }
        }

        return 0;
    }

    public int getCountSteps() {
        return countSteps;
    }

}
