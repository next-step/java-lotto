package calculator.domain;

import calculator.exception.ApplicationException;

import java.util.List;

public class OperatorFinder {

    private static final List<Operator> OPERATOR_LIST = List.of(
            new Addition(),
            new Subtraction(),
            new Multiplication(),
            new Division()
    );

    private OperatorFinder() {
    }

    public static Operator findOperator(String operator) {
        return OPERATOR_LIST.stream()
                .filter(op -> op.supports(operator))
                .findFirst()
                .orElseThrow(() -> new ApplicationException("연산자를 찾을 수 없습니다."));
    }
}
