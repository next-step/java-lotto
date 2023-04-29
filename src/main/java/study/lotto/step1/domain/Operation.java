package study.lotto.step1.domain;

public class Operation {
    private final Operand firstOperand;
    private final Operand secondOperand;
    private final Operator operator;

    public Operation(Operand firstOperand, Operand secondOperand, Operator operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public OperationResult calculate() {
        return operator.calculate(firstOperand, secondOperand);
    }
}
