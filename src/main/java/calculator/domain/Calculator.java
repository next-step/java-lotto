package calculator.domain;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(String value) {
        String[] tokens = splitValidate(value);
        int result = stringToInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            result = calculate(findOperator(tokens[i]), result, stringToInt(tokens[i + 1]));
        }

        return result;
    }

    private static String[] splitValidate(String value) {
        return value.split(" ");
    }

    private static int stringToInt(String token) {
        return Integer.parseInt(token);
    }

    private static int calculate(Operator operator, int result, int number) {
        return operator.operate(result, number);
    }

    private static Operator findOperator(String tokens) {
        return OperatorFactory.of(tokens);
    }
}
