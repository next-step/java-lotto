package calculator;

import java.util.List;

public class Adder {

    private List<Token> tokens;

    public Adder(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int calculate() {
        return tokens.stream().mapToInt(Token::getOperand).sum();
    }

    private int sum(int a, int b) {
        return a + b;
    }
}
