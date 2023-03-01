package CountPairsAlgorithm;

import java.util.*;

public class DuplicateCounter {
    public static int findPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates.size();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 3, 3};
        int[] nums2 = {1, 7, 1, 4, 7, 8};
        int[] nums3 = {1, 2, 2, 3, 4, 6};
        int[] nums4 = {1, 2, 1, 6, 7, 1};
        int[] nums5 = {1, 4, 4, 4, 2, 8};
        int[] nums6 = {2, 2, 2, 2, 2, 2};

        System.out.println(findPairs(nums1)); // output: 3
        System.out.println(findPairs(nums2)); // output: 2
        System.out.println(findPairs(nums3)); // output: 1
        System.out.println(findPairs(nums4)); // output: 1
        System.out.println(findPairs(nums5)); // output: 1
        System.out.println(findPairs(nums6)); // output: 1
    }
}
