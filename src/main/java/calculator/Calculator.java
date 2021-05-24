package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final int MINIMUM_OPERAND_VALUE = 0;
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private final Operands operands;

    public Calculator(String input) {
        this.operands = validateAndExtractOperands(input);
    }

    private Operands validateAndExtractOperands(String input) {
        if (input == null || input.isEmpty()) {
            return new Operands(List.of(MINIMUM_OPERAND_VALUE));
        }

        String[] splitInput = extractOperands(input);

        return validateOperands(splitInput);
    }

    public int sumOperands() {
        return operands.sum();
    }

    private String[] extractOperands(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return splitOperandsByDefaultDelimiter(input);
    }

    private String[] splitOperandsByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private Operands validateOperands(String[] splitedInput) {
        List<Integer> parseInts = new ArrayList<>();

        for (String operand : splitedInput) {
            validateOperand(parseInts, operand);
        }

        return new Operands(parseInts);
    }

    private void validateOperand(List<Integer> parseInts, String operand) {
        try {
            int parsedOperand = Integer.parseInt(operand);

            validatePositiveOperand(parsedOperand);

            parseInts.add(parsedOperand);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 연산 값입니다. : " + operand);
        }
    }

    private void validatePositiveOperand(int parsedOperand) {
        if (parsedOperand < MINIMUM_OPERAND_VALUE) {
            throw new NumberFormatException();
        }
    }
}
