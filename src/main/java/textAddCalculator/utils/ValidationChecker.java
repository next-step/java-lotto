package textAddCalculator.utils;

public class ValidationChecker {
    private static final int ZERO = 0;

    private ValidationChecker() {
    }

    public static boolean isEmptyOrNull(String inputValue) {
        return inputValue == null || inputValue.isEmpty();

    }

    public static void exceptionCheck(String[] inputValue) {
        for(String value : inputValue) {
            checkChar(value);
            checkNegative(value);
        }
    }

    private static void checkNegative(String negative) {
        if(Integer.parseInt(negative) < ZERO) {
            throw new RuntimeException("음수가 입력되었습니다.");
        }
    }

    private static void checkChar(String character) {
        try {
            Integer.parseInt(character);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("문자가 입력되었습니다.");
        }
    }
}
