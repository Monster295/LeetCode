import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author chenxiaolong
 * @since 2025/3/27 16:12:32
 */

public class longestConsecutiveTest {

  public int longestConsecutive(int[] nums) {
    // 用于存放数据元素的集合
    Set<Integer> set = new HashSet<>();
    // 将数组元素存入集合中
    for (int num : nums) {
      set.add(num);
    }
    int longestStreak = 0;
    // 遍历集合中的每个元素
    for (int num : set) {
      // 如果当前元素的前一个元素不在集合中，则说明当前元素是一个序列的起始元素
      if (!set.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;
        // 计算当前序列的长度
        while (set.contains(currentNum + 1)) {
          currentNum++;
          currentStreak++;
        }
        // 更新最长序列的长度
        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    return longestStreak;
  }

  public static void main(String[] args) {
    // 测试上述方法
    int[] nums = new int[]{100, 4, 200, 1, 3, 2};
    longestConsecutiveTest longestConsecutiveTest = new longestConsecutiveTest();
    int result = longestConsecutiveTest.longestConsecutive(nums);
    System.out.println(result); // 输出: 4
  }
}
