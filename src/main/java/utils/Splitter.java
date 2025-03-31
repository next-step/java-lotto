package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    public static List<Integer> splitAndConvertInt(String input) {
        return toIntList(input.split(","));
    }

    private static List<Integer> toIntList(String[] stringNumArray) {
        return Arrays.stream(stringNumArray)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
