package stringcalculator.domain.operator;

import stringcalculator.exception.StringCalculatorIllegalArgumentException;

import java.util.List;

public class OperatorFactory {
    private static final List<Operator> OPERATORS = List.of(
            new Addition(),
            new Subtraction(),
            new Multiplication(),
            new Division()
    );

    private OperatorFactory() {
    }

    public static Operator getOperation(String operator) {
        return OPERATORS.stream()
                .filter(op -> op.supports(operator))
                .findAny()
                .orElseThrow(() -> new StringCalculatorIllegalArgumentException("사칙 연산자를 찾을 수 없습니다."));
    }
}
