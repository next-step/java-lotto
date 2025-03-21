package stringcalcaulator;

import stringcalcaulator.token.ExpressionToken;
import stringcalcaulator.token.ExpressionTokenResolvers;

public class StringCalculator {

    public int calculate(String text) {

        ExpressionIterator iterator = new ExpressionIterator(text);
        ExpressionTokenVisitor visitor = new ExpressionTokenVisitor();

        while (iterator.hasNext()) {
            String token = iterator.next();
            ExpressionToken expressionToken = ExpressionTokenResolvers.resolve(token);
            expressionToken.accept(visitor);
        }

        return visitor.getResult();
    }
}
