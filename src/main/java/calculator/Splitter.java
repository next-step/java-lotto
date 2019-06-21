package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    static final String MESSAGE_OF_NOT_NUMBER_EXCEPTION = "피연산자는 숫자여야 합니다: ";
    static final String MESSAGE_OF_NEGATIVE_NUMBER_EXCEPTION = "피연산자는 0 또는 자연수여야 합니다.";

    private static final String REGEX_OF_NATURAL_NUMBER = "-?\\d+";
    private static final String REGEX_OF_DEFAULT_SEPARATOR = "[,:]";
    private static final String REGEX_OF_CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public List<Integer> extractOperands(String input) {
        List<Integer> operands = new ArrayList<>();
        String[] elementsOnInput = split(input);

        for (String element : elementsOnInput) {
            validateOperandIsNumber(element);
            int operand = Integer.parseInt(element);
            validateOperandIsPositive(operand);
            operands.add(operand);
        }
        return operands;
    }

    private String[] split(String input) {
        String[] elementsOnInput = input.split(REGEX_OF_DEFAULT_SEPARATOR);

        Matcher matcher = Pattern.compile(REGEX_OF_CUSTOM_SEPARATOR).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            elementsOnInput = matcher.group(2).split(customDelimiter);
        }
        return elementsOnInput;
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
