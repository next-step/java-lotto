package calculator.expression;

import java.util.List;

public class Expression {

    private final List<ExpressionComponent> expression;

    private Expression(List<ExpressionComponent> expression) {
        this.expression = expression;
    }

    public static Expression of(String input) {
        return new Expression(ExpressionParser.parse(input));
    }

    public int calculate() {
        int result = expression.get(0).getValue();
        for (int i = 1; i < expression.size(); i += 2) {
            result = expression.get(i).operate(result, expression.get(i + 1).getValue());
        }
        return result;
    }


}
