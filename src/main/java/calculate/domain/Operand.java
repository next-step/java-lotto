package calculate.domain;

import calculate.exception.NotPositiveIntegerException;

import java.util.Objects;

public class Operand {
    private int operand;

    public Operand(int operand) {
        if (operand < 0) {
            throw new NotPositiveIntegerException("피연산자는 양의 정수만 입력 가능 합니다.");
        }
        this.operand = operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return this.operand == operand.operand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}
