package calculator;

import java.util.Arrays;
import java.util.Objects;

public class Operand {
    private int operand;

    private Operand(int operand) {
        this.operand = operand;
    }

    private Operand(String operand) {
        this(Integer.parseInt(operand));
    }

    public static Operand from(String operand) {
        return new Operand(operand);
    }

    public static Operand from(int operand) {
        return new Operand(operand);
    }

    public int getResult() {
        return operand;
    }

    public static boolean isOperand(String token) {
        return token.chars()
                .allMatch(Character::isDigit);
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
        return Objects.hash(operand);
    }
}
