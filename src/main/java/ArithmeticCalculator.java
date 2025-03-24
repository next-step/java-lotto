import java.util.List;

public class ArithmeticCalculator {

    public static Integer calculate(CalculatorInput input) {
        List<String> tokens = input.getTokens();
        int result = parseNumber(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            int operand = parseNumber(tokens.get(i + 1));
            result = calculateWithOperator(operator, result, operand);
        }

        return result;
    }

    private static Integer calculateWithOperator(String operator, int firstNumber, int secondNumber) {
        return ArithmeticOperator.fromSymbol(operator).operate(firstNumber, secondNumber);
    }

    private static int parseNumber(String token) {
        return Integer.parseInt(token);
    }
}
