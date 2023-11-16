package calculator.domain;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(String value) {
        String[] tokens = value.split(" ");
        int result = stringToInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            Operator operator = OperatorFactory.of(tokens[i]);
            int number = stringToInt(tokens[i + 1]);

            result = calculate(operator, result, number);
        }
        return result;
    }

    private static int stringToInt(String token) {
        return Integer.parseInt(token);
    }

    private static int calculate(Operator operator, int result, int number) {
        return operator.operate(result, number);
    }
}
