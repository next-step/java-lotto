package calculator;

public class Calculator {
    private static final String DELIMITER = " ";

    public Calculator() {
    }

    public static int calculate(String[] input) {
        int result = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length - 1; i += 2) {
            Operator operator = Operator.getOperator(input[i]);
            System.out.println(operator);
            result = operator.execute(result, Integer.parseInt(input[i + 1]));
        }
        return result;
    }
}
