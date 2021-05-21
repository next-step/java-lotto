package lotto.domain;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public static LottoNumber of(int number) {
        validateNumber(number);
        return new LottoNumber(number);
    }

    private static void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 " + MIN_LOTTO_NUMBER + "과 " + MAX_LOTTO_NUMBER + "사이의 정수 이어야 합니다.");
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
