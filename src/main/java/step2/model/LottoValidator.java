package step2.model;

public class LottoValidator {
    private static final int MIN = 1;
    private static final int MAX = 45;

    public static void isDigit(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public static void isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    public static void isInRange(String input) {
        int number = Integer.parseInt(input.trim());
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1~45 사이 숫자를 입력해주세요");
        }
    }
}
