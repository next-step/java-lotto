package calculator;

import java.util.List;

public class Adder {

    private List<Token> tokens;

    public Adder(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int calculate() {
        int result = tokens.get(0).getOperand();
        int tokensSize = tokens.size();

        for (int i = 1; i < tokensSize; i++) {
            result = sum(result, tokens.get(i).getOperand());
        }
        return result;
    }

    private int sum(int a, int b) {
        return a + b;
    }
}
