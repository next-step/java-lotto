package calculator;

import calculator.expression.Expression;
import calculator.expression.NumberExpression;
import calculator.tokenizer.ExpressionTokenizer;
import java.util.List;

public class ExpressionParser {

    private final ExpressionTokenizer expressionTokenizer;

    public ExpressionParser(ExpressionTokenizer expressionTokenizer) {
        this.expressionTokenizer = expressionTokenizer;
    }

    public Expression parse(String value) {
        List<String> tokenize = expressionTokenizer.tokenize(value);

        return createExpression(tokenize);
    }

    private static Expression createExpression(List<String> tokenize) {
        if (tokenize.size() >= 3) {
            throw new IllegalArgumentException("잘못된 문법 입니다.");
        }

        Expression before = new NumberExpression(tokenize.get(0));
        for (int i = 1; i < tokenize.size() - 1; i++) {
            NumberExpression numberExpression = new NumberExpression(tokenize.get(i + 1));
            before = Expression.createOperation(tokenize.get(i), before, numberExpression);
        }
        return before;
    }
}
