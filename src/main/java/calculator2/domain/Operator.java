package calculator2.domain;

import java.util.function.BiFunction;

public enum Operator {
    Sum("+", (operand1, operand2) -> operand1 + operand2),
    Subtraction("-", (operand1, operand2) -> operand1 - operand2),
    Multiplication("*", (operand1, operand2) -> operand1 * operand2),
    Division("/", (operand1, operand2) -> (int)operand1 / operand2);

    private final String operationSymbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String operationSymbol, BiFunction<Integer, Integer, Integer> operation) {
        this.operationSymbol = operationSymbol;
        this.operation = operation;
    }

    public int calculate (int operand1, int operand2) {
        return this.operation.apply(operand1, operand2);
    }

    public static Operator find (String operationSymbol) {
        if (operationSymbol.equals("+")) {
            return Sum;
        }
        if (operationSymbol.equals("-")) {
            return Subtraction;
        }
        if (operationSymbol.equals("*")) {
            return Multiplication;
        }
        if (operationSymbol.equals("/")) {
            return Division;
        }
        throw new IllegalArgumentException("연산자는 +, -, *, / 중 하나여야 합니다.");
    }
}
