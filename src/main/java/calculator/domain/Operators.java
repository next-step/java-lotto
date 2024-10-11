package calculator.domain;

import java.util.List;
import java.util.Set;

public class Operators {

    private final Set<String> BASIC_OPERATORS = Set.of("+", "-", "*", "/");

    private List<String> operators;

    public Operators(String... operators) {
        validate(operators);
        this.operators = List.of(operators);
    }

    private void validate(String[] operators) {
        validateNullOrEmpty(operators);
        validateOperators(operators);
    }

    private void validateNullOrEmpty(String[] operators) {
        if (operators == null || operators.length == 0) {
            throw new IllegalArgumentException("연산자를 입력해 주세요.");
        }
    }

    private void validateOperators(String[] operators) {
        for (String operator : operators) {
            isBasicOperator(operator);
        }
    }

    private void isBasicOperator(String operator) {
        if (!BASIC_OPERATORS.contains(operator)) {
            throw new IllegalArgumentException("사용할 수 없는 연산자입니다. : " + operator);
        }
    }
}
