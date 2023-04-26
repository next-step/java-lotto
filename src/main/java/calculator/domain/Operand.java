package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operand {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("^\\d+$");

    private final int operand;

    public Operand(int operand) {
        this.operand = operand;
    }

    public Operand(String operand) {
        validateOperand(operand);
        this.operand = Integer.parseInt(operand);
    }

    public static Operand from(String operand) {
        validateOperand(operand);
        return new Operand(Integer.parseInt(operand));
    }

    public int toInt() {
        return operand;
    }

    private static void validateOperand(String operand) {
        if(operand == null || operand.isEmpty()) {
            throw new IllegalArgumentException("Invalid operand: " + operand);
        }
        Matcher matcher = OPERAND_PATTERN.matcher(operand);
        if(!matcher.find()) {
            throw new IllegalArgumentException("Invalid operand: " + operand);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand1 = (Operand) o;

        return operand == operand1.operand;
    }

    @Override
    public int hashCode() {
        return operand;
    }
}
