package StringCalculator.backend.domain;

import java.util.Objects;
import java.util.function.BinaryOperator;

public class Operand {

    private int number;

    public Operand(int number) {
        checkPositive(number);
        this.number = number;
    }

    private void checkPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력될 수 없습니다.");
        }
    }

    public int apply(BinaryOperator<Integer> formula, Operand other) {
        return formula.apply(this.number, other.number);
    }

    public boolean isZero() {
        return this.number == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
