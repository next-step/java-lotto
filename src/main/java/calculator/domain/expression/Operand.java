package calculator.domain.expression;

import java.util.regex.Pattern;

public class Operand {

    public static final String NEGATIVE_NUMBERS_ERROR_MESSAGE = "Negative numbers are not allowed";
    public static final Pattern OPERAND_PATTERN = Pattern.compile("^[0-9]+$");
    private final int operand;

    public Operand(String operand) {
        isPositiveNumber(operand);
        this.operand = Integer.parseInt(operand);
    }

    public Operand(int operand) {
        isPositive(operand);
        this.operand = operand;
    }

    private void isPositive(int operand) {
        if (operand < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void isPositiveNumber(String number) {
        if (!OPERAND_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(NEGATIVE_NUMBERS_ERROR_MESSAGE);
        }
    }

    public int toInt() {
        return operand;
    }
}

