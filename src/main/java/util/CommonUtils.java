package util;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CommonUtils {
    public static String[] sortedSetToArray(SortedSet<Integer> strings){
        return strings.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    public static SortedSet<Integer> arrayTosotedSet(int[] array){
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));

    }
}
