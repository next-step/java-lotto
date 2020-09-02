package step2.util;

import step1.exception.StringAdderExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {
    private static final String COMMA= ",";

    public static String[] splitNumber(String input) {
        return input.split(COMMA);
    }

    public static List<Integer> castingToList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .peek(StringAdderExceptionHandler::validate)
                .collect(Collectors.toList());
    }
}
