package Lotto;

public class Calculator {

    public static void main(String[] args) {
        System.out.println(Calculator.calculate("10 + 2 + 9"));
    }

    public static int calculate(String valueText) {
        String[] values = valueText.split(" ");

        int result = toNumber(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            Operator operator = Operator.operatorOf(values[i]);
            int number = toNumber(values[i + 1]);

            result = operator.operate(result, number);
        }

        return result;
    }

    private static int toNumber(String value) {
        return Integer.parseInt(value);
    }
}
