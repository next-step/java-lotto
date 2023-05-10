package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParseUtil {

    public static Set<Integer> convertStringToIntegerList(String input, String delimiter){
        return parseIntWithTrim(getSplit(input, delimiter));
    }

    public static Set<Integer> parseIntWithTrim(String[] input){
        return Arrays.stream(input)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }


    public static String[] getSplit(String input, String delimiter) {
        return input.split(delimiter);
    }
}
