package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static final String MESSAGE_OF_NOT_NUMBER_EXCEPTION = "피연산자는 숫자여야 합니다: ";
    static final String MESSAGE_OF_NEGATIVE_NUMBER_EXCEPTION = "피연산자는 0 또는 자연수여야 합니다.";

    private static final String REGEX_OF_DEFAULT_SEPARATOR = "[,:]";
    private static final String REGEX_OF_CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final String REGEX_OF_NATURAL_NUMBER = "-?\\d+";

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] elementsOnInput = splitBySeparator(input);
        return sum(elementsOnInput);
    }

    private String[] splitBySeparator(String input) {
        String[] elementsOnInput = input.split(REGEX_OF_DEFAULT_SEPARATOR);

        Matcher matcher = Pattern.compile(REGEX_OF_CUSTOM_SEPARATOR).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            elementsOnInput = matcher.group(2).split(customDelimiter);
        }
        return elementsOnInput;
    }

    private int sum(String[] elementsOnInput) {
        int result = 0;
        for (String element : elementsOnInput) {
            validateOperandIsNumber(element);
            int operand = Integer.parseInt(element);
            result += operand;
            validateOperandIsPositive(operand);
        }
        return result;
    }


    private void validateOperandIsNumber(String operand) {
        if (!operand.matches(REGEX_OF_NATURAL_NUMBER)) {
            StringBuilder exceptionMessage = new StringBuilder(MESSAGE_OF_NOT_NUMBER_EXCEPTION).append(operand);
            throw new IllegalArgumentException(String.valueOf(exceptionMessage));
        }
    }

    private void validateOperandIsPositive(int operand) {
        if (operand < 0) {
            StringBuilder exceptionMessage = new StringBuilder(MESSAGE_OF_NEGATIVE_NUMBER_EXCEPTION).append(operand);
            throw new IllegalArgumentException(String.valueOf(exceptionMessage));
        }
    }
}
