package step1.domain;

public class Calculator {

    public static int calculate(Expression expression) {
        String[] values = parse(expression.getValue());
        int sum = toInt(values[0]);
        for (int i = 2; i < values.length; i+=2) {
            int cur = toInt(values[i]);
            Operator operator = toOperator(values[i - 1]);
            sum = operator.calculate(sum, cur);
        }
        return sum;
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static Operator toOperator(String value) {
        return Operator.of(value);
    }

    private static String[] parse(String expression) {
        return expression.split(" ");
    }
}
