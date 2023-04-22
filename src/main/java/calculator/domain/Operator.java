package calculator.domain;

import static calculator.domain.OperatorType.*;

public class Operator {

    private final String operator;

    public Operator(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if (isNotOperator(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        this.operator = input;
    }

    public String value() {
        return operator;
    }

    boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    boolean isNotOperator(String operator) {
        return !(operator.equals(PLUS.getCharacter())
                || operator.equals(MINUS.getCharacter())
                || operator.equals(MULTIPLY.getCharacter())
                || operator.equals(DIVIDE.getCharacter()));
    }

    public boolean isPlus() {
        return operator.equals(PLUS.getCharacter());
    }

    public boolean isMinus() {
        return operator.equals(MINUS.getCharacter());
    }

    public boolean isMultiply() {
        return operator.equals(MULTIPLY.getCharacter());
    }

    public boolean isDivide() {
        return operator.equals(DIVIDE.getCharacter());
    }

}

enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    final private String character;

    OperatorType(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}
