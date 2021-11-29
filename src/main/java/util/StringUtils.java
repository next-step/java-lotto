package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    private static final String SPLITERATOR_OF_RAW_INPUT = ",";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String EMPTY_STRING = "";

    public static List<Integer> parseNumbers(String input) {
        String emptySpaceRemoved = input.replaceAll(REGEX_WHITESPACE, EMPTY_STRING);
        return Arrays.stream(emptySpaceRemoved.split(SPLITERATOR_OF_RAW_INPUT))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
