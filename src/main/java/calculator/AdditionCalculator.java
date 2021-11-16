package calculator;

import calculator.strategy.CustomSplitStrategy;
import calculator.strategy.DefaultSplitStrategy;
import calculator.strategy.SplitStrategy;
import java.util.Arrays;
import java.util.List;

public class AdditionCalculator {

    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");
    private static final String JOIN_DELIMITER = "|";
    private static final String DEFAULT_DELIMITER = String.join(JOIN_DELIMITER, DEFAULT_DELIMITERS);

    private final String input;

    private AdditionCalculator(String s) {
        this.input = s;
    }

    public static AdditionCalculator from(String s) {
        return new AdditionCalculator(s);
    }

    public int result() {
        String[] splitInput = getSplitInput();
        return Arrays.stream(splitInput)
            .mapToInt(Integer::parseInt)
            .sum();
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
