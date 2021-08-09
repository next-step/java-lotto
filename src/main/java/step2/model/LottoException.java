package step2.model;

public class LottoException {
    private static final int MIN_AMOUNT = 1000;

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

    public static void isOverMin(String amount) {
        if (Integer.parseInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }
}
