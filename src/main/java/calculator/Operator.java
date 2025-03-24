package calculator;

import java.util.Objects;

public class Operator {

    private String value;

    public Operator(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("연산자는 null이 될 수 없습니다");
        }

        if (!(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))) {
            throw new IllegalArgumentException("잘못된 사칙연산 기호입니다");
        }

        this.value = value;
    }
    public Operand calculate(Operand left, Operand right) {
        if (value.equals("+")) {
            return left.add(right);
        } else if (value.equals("-")) {
            return left.minus(right);
        } else if (value.equals("*")) {
            return left.mul(right);
        } else if (value.equals("/")) {
            return left.div(right);
        }

        return left.add(right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator operator = (Operator) o;
        return Objects.equals(value, operator.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
