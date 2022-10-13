package stringcalculator;

public class App {

    public static final String NOT_CORRECT_INPUT = "올바른 형식의 문자열이 아닙니다";

    private App() {}

    public static int calculate(String source) {
        validation(isNullOrBlank(source));
        return calculate(source.split(" "));
    }

    private static int calculate(String[] inputs) {
        validation(isUnderMinLength(inputs.length));
        int result = firstCalculate(inputs);
        result = calculateRemains(inputs, result);
        return result;
    }

    private static int firstCalculate(String[] inputs) {
        return Calculator.calculate(toInt(inputs[0]), toInt(inputs[2]), inputs[1]);
    }

    private static int calculateRemains(String[] inputs, int result) {
        for (int i = 3; i < inputs.length; i+=2) {
            result = Calculator.calculate(result, toInt(inputs[i + 1]), inputs[i]);
        }
        return result;
    }

    private static int toInt(String numberCandidate) {
        validation(isNotNumeric(numberCandidate));
        return Integer.parseInt(numberCandidate);
    }

    private static void validation(boolean validation) {
        if (validation) {
            throw new IllegalArgumentException(NOT_CORRECT_INPUT);
        }
    }

    private static boolean isNullOrBlank(String source) {
        return source == null || source.isBlank();
    }

    private static boolean isUnderMinLength(int length) {
        return length < 3;
    }

    private static boolean isNotNumeric(String numberCandidate) {
        try {
            Integer.parseInt(numberCandidate);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
