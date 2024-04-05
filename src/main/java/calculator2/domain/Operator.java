package calculator2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public enum Operator {
    Sum("+", (operand1, operand2) -> operand1 + operand2),
    Subtraction("-", (operand1, operand2) -> operand1 - operand2),
    Multiplication("*", (operand1, operand2) -> operand1 * operand2),
    Division("/", (operand1, operand2) -> (int) operand1 / operand2);

    private final String operationSymbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String operationSymbol, BiFunction<Integer, Integer, Integer> operation) {
        this.operationSymbol = operationSymbol;
        this.operation = operation;
    }

    public String operationSymbol() {
        return operationSymbol;
    }

    public static List<String> operationSymbols() {
        Operator[] operators = Operator.values();
        List<String> operationSymbols = new ArrayList<>();
        for (Operator operator : operators) {
            operationSymbols.add(operator.operationSymbol());
        }

        return operationSymbols;
    }

    public int calculate(int operand1, int operand2) {
        try {
            return this.operation.apply(operand1, operand2);
        }
        catch (ArithmeticException arithmeticException) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
    }

    public static Operator find(String operationSymbol) {
        Operator[] operators = Operator.values();
        List<String> operationSymbols = operationSymbols();

        for (int i = 0; i < operationSymbols.size(); i++) {
            if (operationSymbols.get(i).equals(operationSymbol)) {
                return operators[i];
            }
        }

        throw new IllegalArgumentException("연산자는" + operationSymbols + "중 하나여야 합니다.");
    }
}
