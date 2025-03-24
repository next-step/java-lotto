import java.util.List;

public class Calculator {

    public Integer calculate(CalculatorInput input) {
        List<String> tokens = input.getTokens();
        int firstNumber = parseNumber(tokens.get(0));
        
        if (isSingleNumber(tokens)) {
            return firstNumber;
        }
        
        int secondNumber = parseNumber(tokens.get(2));
        return firstNumber + secondNumber;
    }

    private boolean isSingleNumber(List<String> tokens) {
        return tokens.size() == 1;
    }

    private int parseNumber(String token) {
        return Integer.parseInt(token);
    }
}
