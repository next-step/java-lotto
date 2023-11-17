package calculator.domain;

import java.util.List;

public class OperatorFactory {
    private static final List<Operator> OPERATORS = List.of(new Addition(), new Subtraction(), new Multiplication(), new Division());

    public static Operator of(String inputOperator) {
        return OPERATORS.stream()
                .filter(operator -> operator.supports(inputOperator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("지원하는 연산기호가 아닙니다."));
    }
}
