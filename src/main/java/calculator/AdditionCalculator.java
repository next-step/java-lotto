package calculator;

import calculator.exception.AdditionIllegalArgumentException;
import calculator.exception.AdditionNumberFormatException;
import calculator.strategy.CustomSplitStrategy;
import calculator.strategy.DefaultSplitStrategy;
import calculator.strategy.SplitStrategy;
import java.util.Arrays;
import java.util.List;

public class AdditionCalculator {

    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");
    private static final String JOIN_DELIMITER = "|";
    private static final String DEFAULT_DELIMITER = String.join(JOIN_DELIMITER, DEFAULT_DELIMITERS);
    private static final int DEFAULT_VALUE = 0;

    private final String input;

    private AdditionCalculator(String input) {
        this.input = input;
    }

    public static AdditionCalculator from(String input) {
        return new AdditionCalculator(input);
    }

    public int result() {
        if (inputNullOrEmpty()) {
            return DEFAULT_VALUE;
        }

        try {
            return sumSplitInput(getSplitInput());
        } catch (NumberFormatException e) {
            throw new AdditionNumberFormatException();
        }
    }

    private boolean inputNullOrEmpty() {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private int sumSplitInput(String[] splitInput) {
        validNegative(splitInput);

        return Arrays.stream(splitInput)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private void validNegative(String[] splitInput) {
        long count = Arrays.stream(splitInput)
            .mapToInt(Integer::parseInt)
            .filter(num -> num < DEFAULT_VALUE)
            .count();

        if (count > DEFAULT_VALUE) {
            throw new AdditionIllegalArgumentException();
        }
    }

    private String[] getSplitInput() {
        String customDelimiter = DelimiterRegex.getCustomDelimiter(input);
        if (customDelimiter != null) {
            return getSplitInput(new CustomSplitStrategy(), customDelimiter);
        }
        return getSplitInput(new DefaultSplitStrategy(), DEFAULT_DELIMITER);
    }

    private String[] getSplitInput(SplitStrategy splitStrategy, String delimiter) {
        return splitStrategy.getSplitInput(input, delimiter);
    }

}
