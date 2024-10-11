package calculator.domain;

import calculator.util.StringUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Operators {

    private final Set<String> BASIC_OPERATORS = Set.of("+", "-", "*", "/");

    private final List<String> operators;

    public Operators(String... operators) {
        validate(operators);
        this.operators = List.of(operators);
    }

    private void validate(String[] operators) {
        if (StringUtil.isEmpty(operators)) {
            throw new IllegalArgumentException("연산자를 입력해 주세요.");
        }

        validateOperators(operators);
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

    public Iterator<String> iterator() {
        return operators.iterator();
    }
}
