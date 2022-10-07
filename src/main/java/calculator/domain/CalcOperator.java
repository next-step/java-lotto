package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CalcOperator {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";
    private static final List<String> FOUR_OPERATORS = Arrays.asList(PLUS, MINUS, MULTIPLICATION, DIVISION);

    private final String operator;

    public CalcOperator(String operator) {
        this.operator = checkOperator(operator);
    }

    private String checkOperator(String operator) {
        if(FOUR_OPERATORS.contains(operator)) {
            return operator;
        }
        throw new IllegalArgumentException("사칙연산의 기호가 아닙니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalcOperator operator1 = (CalcOperator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
