package lotto.domain;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        if (isNotValidLottoNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이의 숫자여야 합니다.");
        }
        this.number = number;
    }

    private boolean isNotValidLottoNumber(int number) {
        return number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX;
    }

    public int value() {
        return number;
    }
}
