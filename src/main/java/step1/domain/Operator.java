package step1.domain;

import java.util.Arrays;

public enum Operator {

    PLUS("+", Operand::plus),
    MINUS("-", Operand::minus),
    MULTIPLE("*", Operand::multiple),
    DIVIDE("/", Operand::divide);

    private final String operatorValue;
    private final CalculatorExecutor calculatorExecutor;

    Operator(final String operatorValue, final CalculatorExecutor calculatorExecutor) {
        this.operatorValue = operatorValue;
        this.calculatorExecutor = calculatorExecutor;
    }

    public static Operator find(final String token) {
        return Arrays.stream(Operator.values())
            .filter(operator -> token.equals(operator.operatorValue))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    public Operand calculate(final Operand resultOperand, final Operand operand) {
        return this.calculatorExecutor.calculateExecute(resultOperand, operand);
    }

}
