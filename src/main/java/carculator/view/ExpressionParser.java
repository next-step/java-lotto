package carculator.view;

import carculator.domain.token.Operand;
import carculator.domain.token.Operator;
import carculator.domain.token.Token;

import java.util.ArrayList;
import java.util.List;

import static carculator.domain.Calculator.TOKEN_STEP;

public class ExpressionParser {

    public static List<Token> parseTokens(String expression) {
        String[] tokens = expression.split(" ");
        List<Token> result = new ArrayList<>();

        for (int index = 0; index < tokens.length; index++) {
            makeToken(index, result, tokens);
        }

        return result;
    }

    private static void makeToken(int index, List<Token> result, String[] tokens) {
        if (isOperandPosition(index)) {
            result.add(new Operand(parseInt(tokens[index])));
            return;
        }
        result.add(Operator.from(tokens[index]));
    }

    private static boolean isOperandPosition(int index) {
        return index % TOKEN_STEP == 0;
    }

    private static Integer parseInt(String expression) {
        return Integer.parseInt(expression);
    }

}
