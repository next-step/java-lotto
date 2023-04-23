package calculator.domain;

import java.util.Arrays;

import static calculator.domain.OperatorType.values;

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
        return Arrays.stream(values())
                .noneMatch(value -> value.character().equals(input));
    }
}
