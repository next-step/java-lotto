package stringcalcaulator.domain;

public class ExpressionParser {

    public Expression parse(ExpressionIterator iterator) {
        Expression lastExpr = new OperandExpression(iterator.next());

        while (iterator.hasNext()) {
            Operator operator = Operator.from(iterator.next());
            OperandExpression right = new OperandExpression(iterator.next());
            lastExpr = new OperatorExpression(lastExpr, operator, right);
        }

        return lastExpr;
    }

}
