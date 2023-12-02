package lotto.domain;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private LottoNumber() {}

    public static void check(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("유효하지 않은 범위입니다.");
        }
    }
}
