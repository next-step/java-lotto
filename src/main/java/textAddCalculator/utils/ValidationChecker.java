package textAddCalculator.utils;

public class ValidationChecker {
    public static boolean isEmptyOrNull(String inputValue) {
        if(inputValue == null || inputValue.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void exceptionCheck(String[] inputValue) {
        for(String value : inputValue) {
            checkChar(value);
            checkNegative(value);
        }
    }

    private static void checkNegative(String negative) {
        if(Integer.parseInt(negative) < 0) {
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
