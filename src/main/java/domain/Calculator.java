package domain;

import domain.calculation.Addition;
import domain.calculation.Calculation;
import domain.calculation.Division;
import domain.calculation.Multiplication;
import domain.calculation.Subtraction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Calculation> calculationMap = createCalculationMap();
        return calculationMap.get(operator).calculate(result, operand);
    }

    private Map<String, Calculation> createCalculationMap() {
        Map<String, Calculation> map = new HashMap<>();
        map.put("+", new Addition());
        map.put("-", new Subtraction());
        map.put("*", new Multiplication());
        map.put("/", new Division());
        return map;
    }
}
