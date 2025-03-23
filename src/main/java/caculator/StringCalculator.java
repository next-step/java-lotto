package caculator;

public class StringCalculator {

    private static final String BLANK_DELEMETER = " ";

    public static int splitAndCalculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("빈값은 허용하지 않습니다.");
        }

        String[] inputs = split(input);
        int result = toInt(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            result = Operator.calculate(inputs[i], result, toInt(inputs[i + 1]));
        }
        return result;
    }
    public static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    public static String[] split(String text) {
        return text.split(BLANK_DELEMETER);
    }

    public static int toInt(String values) {
        return Integer.parseInt(values);
    }
}
