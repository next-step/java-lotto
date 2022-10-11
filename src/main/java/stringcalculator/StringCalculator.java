package stringcalculator;

public class StringCalculator {
    private static final String DELIMITER = " ";

    private StringCalculator() {
    }

    private static String[] split(String data) {
        return data.split(DELIMITER);
    }

    public static String[] stringValidCheck(String data) {
        if (data == null || data.isBlank()) {
            throw new IllegalArgumentException();
        }
        return split(data);
    }


    public static int calculate(String[] data) {
        int result = Integer.parseInt(data[0]);
        for (int i = 1; i < data.length - 1; i += 2) {
            result = getOperatorExpression(data[i], result, Integer.parseInt(data[i + 1]));
        }
        return result;
    }

    public static int getOperatorExpression(String operator, Integer num1, Integer num2) {
        return Operator.getExpression(operator)
                .mapCalculate(num1, num2);
    }
}
