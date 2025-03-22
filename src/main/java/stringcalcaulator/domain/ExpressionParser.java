package stringcalcaulator.domain;

public class ExpressionParser {

    public Expression parse(ExpressionIterator iterator) {
        Expression lastExpr = null;

        while (iterator.hasNext()) {
            String token = iterator.next();

            if (Operator.isOperator(token)) {
                Operator operator = Operator.from(token);
                OperandExpression right = new OperandExpression(iterator.next());
                lastExpr = new OperatorExpression(lastExpr, operator, right);
                continue;
            }

            lastExpr = new OperandExpression(token);
        }

        return lastExpr;
    }

}
