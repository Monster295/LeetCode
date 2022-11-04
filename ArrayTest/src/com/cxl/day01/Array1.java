package com.cxl.day01;

import org.junit.jupiter.api.Test;

public class Array1 {
    public static void main(String[] args) {
       // int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int[] nums = new int[]{1,3,5,6};
        int target = 9;
        target = 7;
        int index = search1(nums, target);
        System.out.println(index);


    }

    @Test
    public void test1()     //704. 二分查找
    {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        target = 10;
        int index = search1(nums, target);
        System.out.println(index);

    }

    @Test
    public void test2()     //35. 搜索插入位置
    {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        int index = search2(nums, target);
        System.out.println(index);

    }




    public static int search1(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;

        while(left <= right){
            middle = (left + right) / 2;
            if(nums[middle] == target){
                index = middle;
                break;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return index;

    }

    public static int search2(int[] nums, int target){
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        int middle = 0;
        while(left <= right){
            middle = (left + right)/2;
            if(target == nums[middle]){
                index = middle;
                break;
            }else if(target < nums[middle]){
                right = middle - 1;

            }else{
                left = middle + 1;
            }
        }
        if(index != -1){
            return index;
        }else{
            return left;
        }
    }
}
