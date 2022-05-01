package calculator;

public class Expression {
    private final Operand firstOperand;
    private final Operator operator;
    private final Operand secondOperand;

    Expression(Operand firstOperand, Operator operator, Operand secondOperand) {
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
    }

    public int operation() {
        return this.operator.operate(firstOperand.getNumber(), secondOperand.getNumber());
    }
}
