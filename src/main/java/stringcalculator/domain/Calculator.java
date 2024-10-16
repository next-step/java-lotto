package stringcalculator.domain;

import stringcalculator.domain.calculation.Calculation;

import java.util.List;

public class Calculator {
    private final Tokens tokens;

    public Calculator(Tokens tokens) {
        this.tokens = tokens;
    }

    public int calculate() {
        List<Token> tokenList = tokens.getTokens();

        int result = extractOperand(tokenList.get(0));
        int lastOperatorIndex = tokenList.size() - 2;

        for (int operatorIndex = 1; operatorIndex <= lastOperatorIndex; operatorIndex += 2) {
            result = applyOperation(result, tokenList, operatorIndex);
        }

        return result;
    }

    private int extractOperand(Token token) {
        return Integer.parseInt(token.getToken());
    }

    private int applyOperation(int currentResult, List<Token> tokenList, int operatorIndex) {
        String operator = tokenList.get(operatorIndex).getToken();
        int operandIndex = operatorIndex + 1;
        int operand = extractOperand(tokenList.get(operandIndex));
        return performArithmetic(currentResult, operand, operator);
    }

    private int performArithmetic(int result, int operand, String operator) {
        Calculation calculation = Operators.find(operator);
        return calculation.calculate(result, operand);
    }
}