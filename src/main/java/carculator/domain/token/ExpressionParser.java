package carculator.domain.token;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    public static List<Token> parseTokens(String expression) {
        String[] tokens = expression.split(" ");
        List<Token> result = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                result.add(new Operand(parseInt(tokens[i])));
            } else {
                result.add(Operator.from(tokens[i]));
            }
        }

        return result;
    }

    private static Integer parseInt(String expression) {
        return Integer.parseInt(expression);
    }

}
