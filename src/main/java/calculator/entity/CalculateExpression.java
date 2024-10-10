package calculator.entity;

import java.util.function.IntBinaryOperator;

public enum CalculateExpression {
    ADD("+", (prevNumber, number) -> prevNumber + number),
    SUBTRACT("-", (prevNumber, number) -> prevNumber - number),
    MULTIPLY("*", (prevNumber, number) -> prevNumber * number),
    DIVIDE("/", (prevNumber, number) -> prevNumber / number);

    private final String expression;
    private final IntBinaryOperator operationFormula;

    CalculateExpression(String expression, IntBinaryOperator operationFormula) {
        this.expression = expression;
        this.operationFormula = operationFormula;
    }

    public int result(int prevNumber, int number) {
        return this.operationFormula.applyAsInt(prevNumber, number);
    }

    public boolean isMatch(String expression) {
        return this.expression.equals(expression);
    }
}
