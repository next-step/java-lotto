import java.util.List;

public class Calculator {

    public Integer calculate(CalculatorInput input) {
        List<String> tokens = input.getTokens();
        int firstNumber = parseNumber(tokens.get(0));

        if (isSingleNumber(tokens)) {
            return firstNumber;
        }

        int secondNumber = parseNumber(tokens.get(2));
        String operator = tokens.get(1);
        return applyOperation(operator, firstNumber, secondNumber);
    }

    private Integer applyOperation(String operator, int firstNumber, int secondNumber) {
        if ("+".equals(operator)) {
            return firstNumber + secondNumber;
        }
        if ("-".equals(operator)) {
            return firstNumber - secondNumber;
        }
        if ("*".equals(operator)) {
            return firstNumber * secondNumber;
        }
        if ("/".equals(operator)) {
            return firstNumber / secondNumber;
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operator);
    }

    private boolean isSingleNumber(List<String> tokens) {
        return tokens.size() == 1;
    }

    private int parseNumber(String token) {
        return Integer.parseInt(token);
    }
}
