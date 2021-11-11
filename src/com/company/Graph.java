package com.company;

import com.company.Vertex;

import java.util.Stack;

public class Graph {
    private final int MAX_VERTS = 9;
    private Vertex vertexArray[];
    private int adjMat[][];    //матрица смежности
    private int countVerts;
    private Stack<Integer> stack;

    public Graph() {
        vertexArray = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        countVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new Stack<>();
    }

    public void addVertex(char lab) {
        vertexArray[countVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexArray[v].getLabel());
    }

    public void dfs(char [][] array) {
        char player;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 1) {
                    player = array[i][j];
                }
            }
        }

        vertexArray[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            }
            else {
                vertexArray[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int j = 0; j < countVerts; j++) {
            vertexArray[j].wasVisited = false;
        }

    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < countVerts; j++) {
            if (adjMat[v][j] == 1 && vertexArray[j].wasVisited == false) {
                return j; 
            }
        }
        return -1;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

}
