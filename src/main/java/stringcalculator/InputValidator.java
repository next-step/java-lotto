package stringcalculator;


import stringcalculator.arithmetic.ArithmeticOperation;

public class InputValidator {

    public static final String NOT_CORRECT_INPUT = "올바른 형식의 문자열이 아닙니다";

    private InputValidator() {}

    public static void validateInput(String source) {
        validate(isNotNullAndNotBlank(source));
        validate(isUpperMinLength(source.length()));
    }

    public static void validateNumeric(String source) {
        validate(isNumeric(source));
    }

    public static void validateArithmeticSupports(ArithmeticOperation source) {
        validate(isNotNull(source));
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

    private static boolean isNotNull(Object source) {
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
