package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    public static List<Integer> splitAndConvertInt(String input) {
        return toIntList(Arrays.stream(input.split(","))
            .map(String::trim)
            .collect(Collectors.toList()));
    }

    private static List<Integer> toIntList(String[] stringNumArray) {
        return Arrays.stream(stringNumArray)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static List<Integer> toIntList(List<String> stringNumArray) {
        return stringNumArray.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
