package step1;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public static List<Token> tokens(String input) {
        List<Token> tokens = new ArrayList<>();

        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("input is null or empty");
        }

        String[] split = input.split(" ");
        for (String s : split) {
            tokens.add(new Token(s));
        }

        verifyTokens(tokens);

        return tokens;
    }

    private static void verifyTokens(List<Token> tokens) {

        for (Token token : tokens) {
            verifyToken(token);
        }
    }

    private static void verifyToken(Token token) {
        if(!token.isNumber() && !token.isOperator()) {
            throw new IllegalArgumentException("invalid token");
        }
    }

}
