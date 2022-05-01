package calculator.domain;

public abstract class Operator implements Element {
    public abstract NumberElement execute(NumberElement operandA, NumberElement operandB);
}
