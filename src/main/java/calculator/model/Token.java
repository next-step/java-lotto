package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Token {

    private int operand;
    private List<Token> tokens;

    public Token(String parseResult) {
        this.operand = parseStringToInteger(parseResult);
        checkNegative(operand);
    }

    public Token(String[] splitInput) {
        tokens = Arrays.stream(splitInput).map(Token::new).collect(Collectors.toList());
    }

    public int getOperand() {
        return operand;
    }

    private int parseStringToInteger(String parseResult) {

        try {
            return Integer.parseInt(parseResult);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("피연산자가 숫자가 아닙니다.");
        }

    }

    private void checkNegative(int operand) {
        if (operand < 0) {
            throw new RuntimeException("음수입니다");
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Token token = (Token) o;
        return operand == token.operand && Objects.equals(tokens, token.tokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand, tokens);
    }
}
