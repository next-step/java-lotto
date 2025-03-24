package domain;

public class Calculation {

    private final Operands operands;
    private final Operators operators;

    public Calculation(Tokens tokens) {
        this.operands = new Operands();
        this.operators = new Operators();
        initializeOperatorsAndOperands(tokens);
    }

    private void initializeOperatorsAndOperands(Tokens tokens) {
        for (int i = 0; i < tokens.size(); i += 2) {
            operands.addOperand(Operand.of(tokens.getToken(i)));
        }

        for (int i = 1; i < tokens.size(); i += 2) {
            operators.addOperator(Operator.of(tokens.getToken(i)));
        }
    }

    public Integer calculate() {
        Operand firstOperand = operands.getNextOperand();
        Operand secondOperand = operands.getNextOperand();
        Operator operator = operators.getNextOperator();

        Operand operationResult = operator.operate(firstOperand, secondOperand);
        return operationResult.value();
    }
}
