package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    private static final String DELIMETER_BLANK = " ";

    public static List<Integer> parseOperands(String input) {
        return splitInputFormula(input).stream()
                .filter(string -> string.matches("[0-9]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> parseOperators(String input) {
        return splitInputFormula(input).stream()
                .filter(string -> !string.matches("[0-9]+"))
                .collect(Collectors.toList());
    }

    private static List<String> splitInputFormula(String input) {
        return Arrays.asList(input.split(DELIMETER_BLANK));
    }
}
