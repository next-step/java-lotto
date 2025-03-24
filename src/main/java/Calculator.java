import java.util.List;

public class Calculator {

    public Integer calculate(CalculatorInput input) {
        List<String> tokens = input.getTokens();
        int result = parseNumber(tokens.get(0));
        
        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            int operand = parseNumber(tokens.get(i + 1));
            result = applyOperation(operator, result, operand);
        }
        
        return result;
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

    private int parseNumber(String token) {
        return Integer.parseInt(token);
    }
}
