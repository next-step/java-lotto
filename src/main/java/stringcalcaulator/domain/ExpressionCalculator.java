package stringcalcaulator.domain;

public class ExpressionCalculator {

    public int visit(OperandExpression operandExpression) {
        return operandExpression.getValue();
    }

    public int visit(OperatorExpression operatorExpression) {
        int left = operatorExpression.getLeft().accept(this);
        int right = operatorExpression.getRight().accept(this);

        return operatorExpression.calculate(left, right);
    }

}
