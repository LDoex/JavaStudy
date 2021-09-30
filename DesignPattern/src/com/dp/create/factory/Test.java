package com.dp.create.factory;



import java.util.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test{
    public static void main(String[] arg){
        StringBuffer a = new StringBuffer("a");
        StringBuffer b = new StringBuffer("b");
        append(a,b);
        System.out.println(a.toString()+","+b.toString());
        a=b;
        append(a,b);
        System.out.println(a.toString()+","+b.toString());

    }

    public static void append(StringBuffer a, StringBuffer b){
        a.append(b);
        b = a;
    }

    class ToDos{
        String day;
        ToDos(String d){day = d;}
        public boolean equals(Object o){
            return ((ToDos)o).day==this.day;
        }
    }
    public static void add3(Integer i){
        int val = i.intValue();
        val+=3;
        i = new Integer(val);
    }
}




class Solution {
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public boolean islandCount(char[][] grid, int x, int y, int[][] visited){
        if(grid[x][y]=='0' || visited[x][y]==1) return false;
        else{
            visited[x][y] = 1;
            if(x<grid.length-1){
                islandCount(grid, x+1, y, visited);
            }
            if(y<grid[0].length-1){
                islandCount(grid, x, y+1, visited);
            }
            if(x<grid.length-1 && y<grid[0].length-1){
                islandCount(grid, x+1, y+1, visited);
            }
            return true;
        }
    }

    public int solve (char[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0;
        for(int i=0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(islandCount(grid, i, j, visited)){
                    count++;
                }
            }
        }
        return count;
    }
}