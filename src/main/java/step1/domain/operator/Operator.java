package step1.domain.operator;

import java.util.List;
import java.util.Objects;

public class Operator {
    private static final List<String> OPERATORS = List.of(new String[]{"+", "-", "*", "/"});
    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
        validateAllowedOperator();
    }

    public String getOperator() {
        return operator;
    }

    private void validateAllowedOperator() {
        if (OPERATORS.contains(this.operator)) return;
        throw new IllegalArgumentException(this.operator + "은(는) 잘못된 연산자 입니다.");
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
        return operator != null ? operator.hashCode() : 0;
    }
}
