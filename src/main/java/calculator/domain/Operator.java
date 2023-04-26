package calculator.domain;

/**
 * @author : 0giri
 * @since : 2023/04/26
 */
public enum Operator implements ExpressionElement{
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator find(String operator) {
        if (operator.equals(PLUS.operator)) {
            return PLUS;
        }
        if (operator.equals(MINUS.operator)) {
            return MINUS;
        }
        if (operator.equals(MULTIPLY.operator)) {
            return MULTIPLY;
        }
        if (operator.equals(DIVIDE.operator)) {
            return DIVIDE;
        }
        throw new IllegalArgumentException("해당 값과 일치하는 연산자를 찾을 수 없습니다.");
    }
}
