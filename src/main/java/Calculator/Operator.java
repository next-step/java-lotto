package Calculator;

import Calculator.exception.NotFoundOperatorException;
import Calculator.exception.OnlyNumberException;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public enum Operator {
    SUM("+", (op1, op2) -> op1 + op2),
    SUBTRACT("-", (op1, op2) -> op1 - op2),
    MULTIPLY("*", (op1, op2) -> op1 * op2),
    DIVIDE("/", (op1, op2) -> op1 / op2);

    private final String operator;
    private final BinaryOperator<Integer> expression;

    Operator(String operand, BinaryOperator<Integer> expression) {
        this.operator = operand;
        this.expression = expression;
    }

    static Operator findOperator(String operatorName) {
        return Stream.of(values())
                .filter(operator -> operator.operator.equals(operatorName))
                .findFirst()
                .orElseThrow(() -> new NotFoundOperatorException("연산자를 찾을 수 없습니다."));
    }

    int calc(String op1, String op2) {
        return expression.apply(Integer.parseInt(op1), Integer.parseInt(op2));
    }
}
