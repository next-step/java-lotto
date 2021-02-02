package calculator;

public class InputValidator {

    public static boolean checkIsNullOrIsEmpty(String text) {
        return isNull(text) || isEmpty(text);
    }

    private static boolean isEmpty(String text) {
        return text.trim().isEmpty();
    }

    private static boolean isNull(String text) {
        return text == null;
    }

    public static boolean checkIsInvalidInput(String text) {
        return isNegative(text) || isLetter(text);
    }

    public static boolean isNegative(String text) throws RuntimeException {
        int input = Integer.parseInt(text);
        if (input < 0) {
            throw new IllegalArgumentException("음수를 입력하셨습니다.");
        }
        return false;
    }

    public static boolean isLetter(String text) throws RuntimeException {
        try {
            int input = Integer.parseInt(text);
            return false;
        } catch (Exception e) {
            throw new NumberFormatException("입력 형식에 벗어나는 입력입니다.");
        }
    }
}
