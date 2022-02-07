package lotto.domain;

public class LottoNumber {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        validateRange();
    }

    private void validateRange() {
        if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1-45 이내의 숫자여야 합니다.");
        }
    }

    public int getRaw() {
        return number;
    }
}
