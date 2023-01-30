package com.cxl.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] result= generateMatrix(5);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
    }
    Queue queue = new ArrayDeque();
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int loop=0;
        int start=0;
        int count=1;
        int i,j;
        while(loop++ < n/2){
            //模拟上侧从左到右
            for(j=start;j<n-loop;j++){
                result[start][j]=count++;
            }
            //模拟右侧从上到下
            for(i=start;i<n-loop;i++){
                result[i][j]=count++;
            }
            //模拟下侧从右到左
            for(;j>=loop;j--){
                result[i][j]=count++;
            }
            //模拟左侧从下到上
            for(;i>=loop;i--){
                result[i][j]=count++;
            }
            start++;
        }
        if(n%2==1){
            result[start][start]=count;
        }


        return result;
    }

}
