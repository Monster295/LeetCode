import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxiaolong 字母异位词 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * @since 2025/3/27 14:54:15
 */
public class groupAnagramsTest {

  // 解法1: 使用字符串排序
  public List<List<String>> groupAnagrams(String[] strs) {
    // 用于存放结果的集合，key为排序后的字符串，value为原字符串的list
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      // 对每个单词的所有字母进行排序
      Arrays.sort(charArray);
      // 获取排序后的字符串，所有字母异位词经过排序后的key相同
      String key = new String(charArray);
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }

    return new ArrayList<>(map.values());
  }

  // 解法2: 对单词的每个字母进行计数
  public List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      int[] counts = new int[26];
      int length = str.length();
      for (int i = 0; i < length; i++) {
        counts[str.charAt(i) - 'a']++;
      }
      // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        if (counts[i] != 0) {
          sb.append((char) ('a' + i));
          sb.append(counts[i]);
        }
      }
      // 对比上面的解法1，无非是key的构建方式不同，所以还是推荐使用解法1
      String key = sb.toString();
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }
    return new ArrayList<>(map.values());
  }


  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    groupAnagramsTest groupAnagrams = new groupAnagramsTest();
    List<List<String>> result = groupAnagrams.groupAnagrams(strs);
    System.out.println(result);
  }
}
