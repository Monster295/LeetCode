import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxiaolong
 *  两数之和 给定一个整数数组 nums 和一个整数目标值 target， 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * <p>
 * 你可以按任意顺序返回答案。
 * @since 2025/3/27 14:31:25
 */
public class twoSum {

  // 解法1:暴力遍历

  public int[] twoSum1(int[] nums, int target) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        // 找到两数之和为target的下标
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[0];
  }


  // 解法2:使用哈希表
  public static int[] twoSum(int[] nums, int target) {
    // 用于记录数据元素 及 下标的map，其中key为数据元素，value为下标
    Map<Integer, Integer> hashTable = new HashMap<>();
    // 只需要遍历一次数组
    for (int i = 0; i < nums.length; i++) {
      // 计算目标结果与当前数组元素的差值
      int temp = target - nums[i];
      // 如果hashTable中包含这个差值，则返回对应的元素下标
      if (hashTable.containsKey(temp)) {
        return new int[]{hashTable.get(temp), i};
      }
      //否则，将当前元素和下标存入hashTable中
      hashTable.put(nums[i], i);
    }

    return new int[0];
  }

  public static void main(String[] args) {
    // 测试上述方法
    int[] nums = new int[]{2, 7, 11, 15};
    int target = 9;
    int[] ints = twoSum(nums, target);
    System.out.println(ints[0] + " " + ints[1]);
  }
}
