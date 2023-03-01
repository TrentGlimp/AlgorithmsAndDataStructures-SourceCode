package CountPairsAlgorithm;

import java.util.*;

public class DuplicateCounter {
    public static <Item> int findPairs(Item[] arr) {
        Set<Item> set = new HashSet<>();
        Set<Item> duplicates = new HashSet<>();
        for (Item element : arr) {
            if (!set.add(element)) {
                duplicates.add(element);
            }
        }
        return duplicates.size();
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 1, 2, 2, 3, 3};
        Double[] doubles = {1.1, 1.2, 2.2, 2.2, 3.3, 3.3};
        String[] strings = {"apple", "banana", "cranberry", "avocado", "banana", "cherry"};
        Character[] chars = {'a', 'b', 'a', 'c', 'd', 'd'};
        Boolean[] bools = {true, true, false, false, true, false};

        System.out.println(findPairs(ints)); // output: 3
        System.out.println(findPairs(doubles)); // output: 2
        System.out.println(findPairs(strings)); // output: 1
        System.out.println(findPairs(chars)); // output: 2
        System.out.println(findPairs(bools)); // output: 2
    }
}
