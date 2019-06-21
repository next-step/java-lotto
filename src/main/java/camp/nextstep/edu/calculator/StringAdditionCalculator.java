package camp.nextstep.edu.calculator;

import java.util.Objects;
import java.util.stream.Stream;

public class StringAdditionCalculator {

    private static final String EMPTY_STRING = "";
    private static final String REGEX_DELIMITERS = "[,:]";
    private static final String PREFIX_OF_CUSTOM_DELIMITER = "//";
    private static final int ZERO = 0;
    private static final int INDEX_OF_CUSTOM_DELIMITER = 2;
    private static final int INDEX_OF_BEGINNING_TOKENS = 4;

    public int calculate(String input) {
        if (input == null) {
            return ZERO;
        }
        if (input.startsWith(PREFIX_OF_CUSTOM_DELIMITER)
                && input.length() >= 4
                && Objects.equals('\n', input.charAt(3))) {
            final char customDelimiterCharacter = input.charAt(INDEX_OF_CUSTOM_DELIMITER);
            final String customDelimiter = String.valueOf(customDelimiterCharacter);
            final String restOfInput = input.substring(INDEX_OF_BEGINNING_TOKENS);
            return this.resolve(customDelimiter, restOfInput);
        }
        return this.resolve(REGEX_DELIMITERS, input);
    }

    private int resolve(String regexOfDelimiter, String tokens) {
        if (EMPTY_STRING.equals(tokens)) {
            return ZERO;
        }
        final String[] splitString = tokens.split(regexOfDelimiter);
        if (this.hasNegativeNumber(splitString)) {
            throw new RuntimeException();
        }
        return Stream.of(splitString)
                .map(Integer::parseInt)
                .reduce(ZERO, Integer::sum);
    }

    private boolean hasNegativeNumber(String[] splitString) {
        return Stream.of(splitString)
                .map(Integer::parseInt)
                .anyMatch(number -> number < ZERO);
    }

}
