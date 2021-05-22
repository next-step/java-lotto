package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final Operands operands;

    public Calculator(String input, String delimiter) {
        this.operands = makeOperandsByInput(input, delimiter);
    }

    public int sumOperands() {
        return operands.sum();
    }

    private Operands makeOperandsByInput(String input, String delimiter) {
        String[] splitedInput = splitOperandsByDelimiter(input, delimiter);

        return new Operands(validateOperands(splitedInput));
    }

    private List<Integer> validateOperands(String[] splitedInput) {
        List<Integer> parseInts = new ArrayList<>();

        for (String operand : splitedInput) {
            validateOperand(parseInts, operand);
        }

        return parseInts;
    }

    private void validateOperand(List<Integer> parseInts, String operand) {
        try {
            parseInts.add(Integer.parseInt(operand));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 연산값입니다. : " + operand);
        }
    }

    private String[] splitOperandsByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }
}
