package calculator.domain;

import java.util.Arrays;
import java.util.Objects;

public class Operator {
    private final String operator;

    public Operator(String operator) {
        if (isOperator(operator).equals(OperatorType.EMPTY))
            throw new IllegalArgumentException("올바른 사칙연산이 아닙니다.");
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }

    private OperatorType isOperator(String operator) {
        return Arrays.stream(OperatorType.values())
                .filter(operatorType -> operatorType.hasSymbol(operator))
                .findAny()
                .orElse(OperatorType.EMPTY);
    }

}
