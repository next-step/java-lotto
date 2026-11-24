package lotto.view;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static int parseAmount(String input) {
        return toInt(input);
    }

    public static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER, -1))
                .map(InputParser::toInt)
                .toList();
    }

    private static int toInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a number: " + value);
        }
    }
}
