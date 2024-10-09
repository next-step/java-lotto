package domain;

import java.util.List;

public class Calculator {
    private final Tokens tokens;
    public Calculator(Tokens tokens) {
        this.tokens = tokens;
    }

    public int calculate() {
        List<Token> tokenList = tokens.getTokens();

        int result = parseOperand(tokenList.get(0));
        int lastOperatorIndex = tokenList.size() - 2;

        for (int operatorIndex = 1; operatorIndex <= lastOperatorIndex; operatorIndex += 2) {
            result = executeOperation(result, tokenList, operatorIndex);
        }

        return result;
    }

    private int parseOperand(Token token) {
        return Integer.parseInt(token.getToken());
    }

    private int executeOperation(int currentResult, List<Token> tokenList, int operatorIndex) {
        String operator = tokenList.get(operatorIndex).getToken();
        int operandIndex = operatorIndex + 1;
        int operand = parseOperand(tokenList.get(operandIndex));
        return executeArithmetic(currentResult, operand, operator);
    }

    private int executeArithmetic(int result, int operand, String operator) {
        switch (operator) {
            case "+":
                return result + operand;
            case "-":
                return result - operand;
            case "*":
                return result * operand;
            case "/":
                return result / operand;
            default:
                throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
        }
    }
}
