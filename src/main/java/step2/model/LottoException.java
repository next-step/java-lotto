package step2.model;

public class LottoException {
    public static boolean isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }

        return false;
    }
}
