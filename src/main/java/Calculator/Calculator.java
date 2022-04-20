package Calculator;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Calculator {
    SUM("+", (op1, op2) -> op1 + op2),
    SUBTRACT("-", (op1, op2) -> op1 - op2),
    MULTIPLY("*", (op1, op2) -> op1 * op2),
    DIVIDE("/", (op1, op2) -> op1 / op2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> exp;

    Calculator(String operand, BiFunction<Integer, Integer, Integer> exp) {
        this.operator = operand;
        this.exp = exp;
    }

    public static Calculator findOperator(String operatorName) {
        return Stream.of(values())
                .filter(operator -> operator.operator.equals(operatorName))
                .findFirst()
                .orElse(null);
    }

    public int calc(String op1, String op2) {
        return exp.apply(Integer.parseInt(op1), Integer.parseInt(op2));
    }
}
