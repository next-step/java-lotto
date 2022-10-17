package stringcalculator;

public class App {

    public static final String NOT_CORRECT_INPUT = "올바른 형식의 문자열이 아닙니다";

    private App() {
    }

    public static int calculate(String input) {
        validate(input);
        return calculate(split("+ " + input));
    }

    private static void validate(String source) {
        validate(isNotNullAndNotBlank(source));
        validate(isUpperMinLength(source.length()));
    }

    private static String[] split(String source) {
        return source.split(" ");
    }

    private static int calculate(String[] inputs) {
        int result = 0;
        Calculator calculator = new Calculator();
        for (int i = 1; i < inputs.length; i += 2) {
            result = calculator.calculate(result, toInt(inputs[i]), inputs[i - 1]);
        }
        return result;
    }

    private static int toInt(String numberCandidate) {
        validate(isNumeric(numberCandidate));
        return Integer.parseInt(numberCandidate);
    }

    private static void validate(boolean isValid) {
        if (!isValid) {
            throw new IllegalArgumentException(NOT_CORRECT_INPUT);
        }
    }

    private static boolean isNotNullAndNotBlank(String source) {
        return isNotNull(source) && isNotBlank(source);
    }

    private static boolean isNotBlank(String source) {
        return !source.isBlank();
    }

    private static boolean isNotNull(String source) {
        return source != null;
    }

    private static boolean isUpperMinLength(int length) {
        return length > 4;
    }

    private static boolean isNumeric(String numberCandidate) {
        try {
            Integer.parseInt(numberCandidate);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
