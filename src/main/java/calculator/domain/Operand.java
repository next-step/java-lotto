package calculator.domain;

import calculator.Validator;

public class Operand {
    private static final String WRONG_OPERAND_VALUE_MESSAGE = "잘못된 피연사자입니다.";
    private final double value;

    private Operand(String value) {
        if (!Validator.isNumber(value)) {
            throw new IllegalArgumentException(WRONG_OPERAND_VALUE_MESSAGE);
        }
        this.value = Double.parseDouble(value);
    }

    public static Operand newOperand(String value) {
        return new Operand(value);
    }

    public double value() {
        return value;
    }
}
