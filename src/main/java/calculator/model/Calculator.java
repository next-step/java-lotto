package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.model.Expression.splitByTokens;

public class Calculator {

    public static int run(String input) {
        input = input.trim();
        Expression.validate(input);

        if (Expression.isNumber(input)) {
            return Integer.parseInt(input);
        }
        return run(calculateOnce(input));
    }

    private static String calculateOnce(String expression) {
        List<String> subExpressions = splitFirstSubExpression(expression);
        String binomial = subExpressions.get(0);
        String restExpressions = subExpressions.get(1);

        List<String> tokens = splitByTokens(binomial);
        Operator operator = Operator.getBySymbol(tokens.get(1));
        int result = operator.calculate(
                Integer.parseInt(tokens.get(0)),
                Integer.parseInt(tokens.get(2))
        );

        return String.valueOf(result) + " " + restExpressions;
    }

    private static List<String> splitFirstSubExpression(String expression) {
        List<String> tokens = splitByTokens(expression);

        String binomial = String.join(" ", tokens.subList(0, 3));
        String restExpression = String.join(" ", tokens.subList(3, tokens.size()));
        return List.of(binomial, restExpression);
    }
}
