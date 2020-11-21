package util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonUtils {
    public static String[] setToArray(Set<Integer> strings){
        return strings.stream()
                .map(String::valueOf)
                .toArray(String[]::new);
    }

    public static Set<Integer> arrayToset(int[] array){
        return Arrays.stream(array).boxed().collect(Collectors.toSet());

    }
}
