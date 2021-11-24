package calculator;

import calculator.exception.AdditionIllegalArgumentException;
import calculator.exception.AdditionNumberFormatException;
import calculator.strategy.CustomSplitStrategy;
import calculator.strategy.DefaultSplitStrategy;
import calculator.strategy.SplitStrategy;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AdditionCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int COMPARISON_VALUE = 0;
    private static final int DEFAULT_RETURN_VALUE = 0;

    private final String input;

    private AdditionCalculator(String input) {
        this.input = input;
    }

    public static AdditionCalculator from(String input) {
        return new AdditionCalculator(input);
    }

    public int result() {
        if (inputNullOrEmpty()) {
            return DEFAULT_RETURN_VALUE;
        }
        return sumSplitInput(getSplitInput());
    }

    private boolean inputNullOrEmpty() {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private int sumSplitInput(String[] splitInput) {
        IntStream intStream = this.mapToInt(splitInput);
        validNegativeValue(intStream);

        return intStream.sum();
    }

    private void validNegativeValue(IntStream intStream) {
        long count = intStream.filter(num -> num < COMPARISON_VALUE)
            .count();

        if (count > COMPARISON_VALUE) {
            throw new AdditionIllegalArgumentException();
        }
    }

    private IntStream mapToInt(String[] splitInput) {
        try {
            return Arrays.stream(splitInput)
                .mapToInt(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new AdditionNumberFormatException();
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
