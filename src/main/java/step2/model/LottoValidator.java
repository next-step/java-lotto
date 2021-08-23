package step2.model;

public class LottoValidator {
    public static void isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    public static void isDigit(String input) {
        if (!input.trim().matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public static int changeToInt(String input) {
        return Integer.parseInt(input.trim());
    }
}
