package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static final int MINIMUM_OPERAND_VALUE = 0;

    private final Operands operands;

    public Calculator(String input) {
        this.operands = validateAndExtractOperands(input);
    }

    private Operands validateAndExtractOperands(String input) {
        if (input == null || input.isEmpty()) {
            return new Operands(List.of(MINIMUM_OPERAND_VALUE));
        }

        return validateAndAppendOperands(new Extractor(input).extractOperands());
    }

    public int sumOperands() {
        return operands.sum();
    }

    private Operands validateAndAppendOperands(String[] splitedInput) {
        List<Integer> parseInts = new ArrayList<>();

        for (String operand : splitedInput) {
            int validatedOperand = validateOperand(operand);
            parseInts.add(validatedOperand);
        }

        return new Operands(parseInts);
    }

    private int validateOperand(String operand) {
        try {
            int parsedOperand = Integer.parseInt(operand);

            validatePositiveOperand(parsedOperand);

            return parsedOperand;

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
