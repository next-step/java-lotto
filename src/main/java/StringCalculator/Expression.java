package StringCalculator;

import java.util.List;

public class Expression {
    private static final String DELIMITER = " ";
    private List<String> expression;

    private Expression(List<String> expression) {
        this.expression = expression;
    }

    public static Expression create(String input) {
        return new Expression(parseExpression(input));
    }

    private static List<String> parseExpression(String input) {
        return List.of(input.split(DELIMITER));
    }

    public int calculate() {
        Operand result = toNumber(0);
        for (int index = 1; index < this.expression.size(); index += 2) {
            result = result.calculrate(toOperator(index), toNumber(index + 1));
        }
        return result.parseInt();
    }

    private Operand toNumber(int index) {
        return new Operand(this.expression.get(index));
    }

    private Operator toOperator(int index) {
        return Operator.findBySymbol(this.expression.get(index));
    }
}
