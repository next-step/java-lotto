package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseUtil {

    public static List<Integer> convertStringToIntegerList(String input, String delimiter){
        return parseInt(getTrim(getSplit(input, delimiter)));
    }

    public static List<Integer> parseInt(String[] input){
        return Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static String[] getTrim(String[] input) {
        return Arrays.stream(input).map(String::trim).toArray(String[]::new);
    }

    public static String[] getSplit(String input, String delimiter) {
        return input.split(delimiter);
    }
}
