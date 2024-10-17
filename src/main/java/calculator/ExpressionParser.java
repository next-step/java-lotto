package calculator;

import calculator.expression.DivideExpression;
import calculator.expression.Expression;
import calculator.expression.MultiplyExpression;
import calculator.expression.NumberExpression;
import calculator.expression.PlusExpression;
import calculator.expression.SubtractExpression;
import java.util.List;

public class ExpressionParser {

    private final ExpressionTokenizer expressionTokenizer;

    public ExpressionParser(ExpressionTokenizer expressionTokenizer) {
        this.expressionTokenizer = expressionTokenizer;
    }

    public Expression parse(String value) {
        List<String> tokenize = expressionTokenizer.tokenize(value);
        Expression before = new NumberExpression(tokenize.get(0));
        for (int i = 1; i < tokenize.size(); i++) {
            if (tokenize.get(i).equals("+")) {
                before = new PlusExpression(before, new NumberExpression(tokenize.get(i + 1)));
            } else if (tokenize.get(i).equals("-")) {
                before = new SubtractExpression(before, new NumberExpression(tokenize.get(i + 1)));
            } else if (tokenize.get(i).equals("*")) {
                before = new MultiplyExpression(before, new NumberExpression(tokenize.get(i + 1)));
            } else if (tokenize.get(i).equals("/")) {
                before = new DivideExpression(before, new NumberExpression(tokenize.get(i + 1)));
            }
        }
        return before;
    }
}
