package caculator;

import java.util.Arrays;

public class StringCalculator {

    private static final String BLANK_DELEMETER = " ";

    public static int splitAndCalculate(String input) {
        isBlank(input);
        return calculateInOrder(split(input));
    }

    public static int calculateInOrder(String[] inputs) {
        int result = toInt(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            result = Operator.calculate(inputs[i], result, toInt(inputs[i + 1]));
        }
        return result;
    }

    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈값은 허용하지 않습니다.");
        }
    }

    public static String[] split(String text) {
        return text.split(BLANK_DELEMETER);
    }

    public static int toInt(String values) {
        return Integer.parseInt(values);
    }

}
