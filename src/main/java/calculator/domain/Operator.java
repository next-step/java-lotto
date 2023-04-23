package calculator.domain;

import static calculator.domain.OperatorType.*;

public class Operator {

    private final OperatorType operatorType;

    public Operator(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if (isNotOperator(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        this.operatorType = OperatorType.of(input);
    }

    public OperatorType value() {
        return this.operatorType;
    }

    boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    boolean isNotOperator(String input) {
        return !(input.equals(PLUS.getCharacter())
                || input.equals(MINUS.getCharacter())
                || input.equals(MULTIPLY.getCharacter())
                || input.equals(DIVIDE.getCharacter()));
    }

}
