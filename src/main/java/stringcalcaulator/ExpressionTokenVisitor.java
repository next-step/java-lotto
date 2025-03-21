package stringcalcaulator;

import stringcalcaulator.token.OperandToken;
import stringcalcaulator.token.OperatorToken;

public class ExpressionTokenVisitor {

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
