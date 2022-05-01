package calculator;

public class Expression {
    private final Operand operand1;
    private final Operand operand2;
    private final Operator operator;

    Expression(Operand operand1, Operator operator, Operand operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public int operation() {
        return this.operator.operate(operand1.getNumber(), operand2.getNumber());
    }
}
