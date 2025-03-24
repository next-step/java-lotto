import java.util.List;

public class Calculator {

    public Integer calculate(CalculatorInput input) {
        List<String> tokens = input.getTokens();
        int result = parseNumber(tokens.get(0));
        
        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            int operand = parseNumber(tokens.get(i + 1));
            result = calculateWithOperator(operator, result, operand);
        }
        
        return result;
    }

    private Integer calculateWithOperator(String operator, int firstNumber, int secondNumber) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return divide(firstNumber, secondNumber);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operator);
        }
    }

    private int divide(int dividend, int divisor) {
        validateDivision(divisor);
        return dividend / divisor;
    }

    private void validateDivision(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    private int parseNumber(String token) {
        return Integer.parseInt(token);
    }
}
