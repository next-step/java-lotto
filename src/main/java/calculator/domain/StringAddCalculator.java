package calculator.domain;

import calculator.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");
    public static final int EMPTY_VALUE_RETURN_ZERO = 0;
    private final InputNumbers inputNumbers;

    public StringAddCalculator(InputNumbers inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public static int splitAndSum(String input) {
        String newInput = input.trim();
        String newDelimiter = DEFAULT_DELIMITER;
        if (StringUtils.isEmpty(newInput)) {
            return EMPTY_VALUE_RETURN_ZERO;
        }
        if (newInput.length() == 1) {
            InputNumber inputNumber = new InputNumber(newInput);
            return inputNumber.getNumber();
        }
        Matcher matcher = hasCustomDelimiter(newInput);
        if (matcher.find()) {
            newDelimiter = matcher.group(1);
            newInput = matcher.group(2);
        }
        if (newInput.contains("-")) {
            throw new RuntimeException("음수를 입력하면 안됩니다.");
        }
        String[] output = splitInput(newInput, newDelimiter);
        InputNumbers inputNumbers = new InputNumbers(output);
        return inputNumbers.sum();
    }

    private static String[] splitInput(String newInput, String newDelimiter) {
        return newInput.split(newDelimiter);
    }

    private static Matcher hasCustomDelimiter(String input) {
        return PATTERN.matcher(input);
    }


}
