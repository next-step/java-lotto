package calculator;

public class Calculator {
    private static final String DELIMITER = " ";

    public Calculator() {
    }

    public int calculate(String input) {
        String[] str = split(input);
        int result = Integer.parseInt(str[0]);
        for (int i = 1; i < str.length - 1; i += 2) {
            Operator operator = Operator.getOperator(str[i]);
            result = operator.execute(result, Integer.parseInt(str[i + 1]));
        }
        return result;
    }

    public String[] split(String input) {
        return input.split(DELIMITER);
    }
}
