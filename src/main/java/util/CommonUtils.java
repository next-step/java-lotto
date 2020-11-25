package util;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CommonUtils {
    public static String[] sortedSetToArray(SortedSet<?> strings){
        return strings.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    public static SortedSet<Integer> arrayToSortedSet(int[] array){
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));
    }

}
