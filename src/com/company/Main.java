package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Main {

   private static char[][] pathArray;

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("C:\\Users\\ольга\\IdeaProjects\\BonusProject\\src\\com\\company\\INPUT.TXT"));
        int h = buffReader.read();
        int m = buffReader.read();
        int n = buffReader.read();
        n = n * h;

         pathArray = new char[m][n];

         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String line = buffReader.readLine();
                for (int k = 0; k < line.length(); k++) {
                    if (!line.equals(" ")) {
                        pathArray[m][n] = line.charAt(k);
                    } else {
                        buffReader.readLine();
                    }
                }
            }
        }

        Graph graph = new Graph();
        graph.dfs(pathArray);

        int timeCount = (graph.getStack().size() - 1) * 5;
        System.out.println(timeCount);
    }

}
