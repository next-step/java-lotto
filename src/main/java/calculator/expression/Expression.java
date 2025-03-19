package calculator.expression;

import java.util.List;

public class Expression {

    private List<ExpressionComponent> expression;

    private Expression(List<ExpressionComponent> expression) {
        this.expression = expression;
    }

    public static Expression of(String input) {
        return new Expression(ExpressionParser.parse(input));
    }


}
