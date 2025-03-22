package stringcalcaulator.domain;

import stringcalcaulator.domain.token.ExpressionToken;
import stringcalcaulator.domain.token.ExpressionTokenResolvers;

public class StringCalculator {

    public int calculate(String expression) {
        ExpressionIterator iterator = new ExpressionIterator(expression);
        ExpressionTokenCalculatorVisitor visitor = new ExpressionTokenCalculatorVisitor();

        while (iterator.hasNext()) {
            String token = iterator.next();
            ExpressionToken expressionToken = ExpressionTokenResolvers.resolve(token);
            expressionToken.accept(visitor);
        }

        return visitor.getResult();
    }
}
