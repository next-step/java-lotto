package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Digit {
    private final static String DIGIT_REGEX = "^[0-9]*$";

    public static List<Integer> parseDigits(List<String> inputs) {
        return inputs.stream()
                .filter(Digit::isDigit)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean isDigit(String inputString) {
        return inputString.matches(DIGIT_REGEX);
    }
}
