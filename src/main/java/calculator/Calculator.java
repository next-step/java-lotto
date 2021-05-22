package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static final int MINIMUM_OPERAND_VALUE = 0;
    public static final int DELIMITER_POSITION = 1;

    private final Operands operands;

    public Calculator(String input) {
        char delimiter = validateAndExtractDelimiter(input);

        this.operands = makeOperandsByInput(input, String.valueOf(delimiter));
    }

    public Calculator(String input, String delimiter) {
        this.operands = makeOperandsByInput(input, delimiter);
    }

    private char validateAndExtractDelimiter(String input) {
        char delimiter = extractDelimiter(input);

        Delimiters.validateExistDelimiter(delimiter);

        return delimiter;
    }

    private char extractDelimiter(String input) {
        return input.charAt(DELIMITER_POSITION);
    }

    public int sumOperands() {
        return operands.sum();
    }

    private Operands makeOperandsByInput(String input, String delimiter) {
        String[] splitedInput = splitOperandsByDelimiter(input, delimiter);

        return validateOperands(splitedInput);
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

    private String[] splitOperandsByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }
}
