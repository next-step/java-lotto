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

    public static int validatedInput(String text) throws RuntimeException {
        int number = 0;
        try {
            number = Integer.parseInt(text);
            checkIsNegative(text);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("입력 형식에 벗어나는 입력입니다.");
        }
        return number;
    }

    public static void checkIsNegative(String text) throws RuntimeException {
        int input= Integer.parseInt(text);
        if(input < 0) {
            throw new RuntimeException("음수를 입력하셨습니다.");
        }
    }
}
