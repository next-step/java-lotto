package stringcalculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class Operator {
    private static final String OPERATORS = "[-*/+]";
    private String operator;

    public Operator(String operator) {
        if(isOperator(operator)) {
            throw new IllegalArgumentException("연산자는 +, -, *, / 기호만 입력 가능합니다.");
        }
        this.operator = operator;
    }

    private boolean isOperator(String operator) {
        return !Pattern.matches(OPERATORS, operator);
    }

    public static boolean isAddition(Operator operator) {
        return operator.equals(new Operator("+"));
    }

    public static boolean isSubtraction(Operator operator) {
        return operator.equals(new Operator("-"));
    }

    public static boolean isMultiplication(Operator operator) {
        return operator.equals(new Operator("*"));
    }

    public static boolean isDivision(Operator operator) {
        return operator.equals(new Operator("/"));
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
}
