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
            Operator operator = Operator.getExpression(data[i]);
            result = operator.calculate(result, Integer.parseInt(data[i + 1]));

        }
        return result;
    }
}
