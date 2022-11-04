package com.cxl.day01;

public class Q35 {
    public static void main(String[] args) {
        int [] nums = new int []{1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums,target));


    }
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        int index=-1;
        while(left<=right){
            mid=(left+right)/2;
            if(target==nums[mid]){
                index=mid;
                break;
            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(index!=-1){
            return index;
        }else{
            return right+1;
        }
    }
}
