package calculator;

public class StringCalculator {

    public static String[] split(String textInput) {
        isBlank(textInput);
        return null;
    }

    private static void isBlank(String textInput) {
        if (textInput == null || textInput.isBlank()) {
            throw new IllegalArgumentException("입력된 문자열이 null 또는 공백 일 수 없습니다.");
        }
    }

}
