import java.util.List;

public class Calculator {
    public Integer calculate(CalculatorInput input) {
        List<String> tokens = input.getTokens();
        int firstNumber = parseNumber(tokens.get(0));
        int secondNumber = parseNumber(tokens.get(2));
        return firstNumber + secondNumber;
    }

    private int parseNumber(String token) {
        return Integer.parseInt(token);
    }
}
