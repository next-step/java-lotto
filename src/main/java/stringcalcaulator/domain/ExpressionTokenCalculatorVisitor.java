package stringcalcaulator.domain;

import stringcalcaulator.domain.token.OperandToken;
import stringcalcaulator.domain.token.OperatorToken;

public class ExpressionTokenCalculatorVisitor {

    private OperandToken lastOperand;
    private OperatorToken lastOperator;

    public void visit(OperandToken operandToken) {
        if (lastOperand == null) {
            lastOperand = operandToken;
            return;
        }

        lastOperand = lastOperator.calculate(lastOperand, operandToken);
        lastOperator = null;
    }

    public void visit(OperatorToken operatorToken) {
        lastOperator = operatorToken;
    }

    public int getResult() {
        return lastOperand.getValue();
    }

}
