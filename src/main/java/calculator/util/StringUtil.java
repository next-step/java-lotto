package calculator.util;

public class StringUtil {

    public static String isEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백을 입력할 수 없습니다.");
        }

        return input;
    }
}
