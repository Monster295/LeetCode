package com.cxl.test;

import java.util.Arrays;

/**
 * CXL
 * 2022/12/27  18:08
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 5, 1, 8, 7, 4, 6, 9};
        Bsort(array);

    }

    public static void Bsort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
