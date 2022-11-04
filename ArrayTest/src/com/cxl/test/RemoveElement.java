package com.cxl.test;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int result = removeElement(nums, 3);
        System.out.println(result);
    }
    public static int removeElement(int[] nums, int val) {
        int slow=0;
        int fast=0;
        for(fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
