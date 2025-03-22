package stringcalcaulator.domain;

import java.util.LinkedList;

public class ExpressionParser {

    private final LinkedList<Expression> stack = new LinkedList<>();

    public Expression parse(ExpressionIterator iterator) {
        while (iterator.hasNext()) {
            String token = iterator.next();

            if (Operator.isOperator(token)) {
                Operator operator = Operator.from(token);
                Expression left = stack.pop();
                OperandExpression right = new OperandExpression(iterator.next());
                OperatorExpression expr
                    = new OperatorExpression(left, operator, right);
                stack.push(expr);
                continue;
            }

            stack.push(new OperandExpression(token));
        }

        return stack.pop();
    }

}
