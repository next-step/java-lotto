package lotto.domain;

public class LottoNumber {

    private static final int LOWER_BOUND_LOTTO = 1;
    private static final int UPPER_BOUND_LOTTO = 46;
    private final int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        checkIsValid(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void checkIsValid(int lottoNumber) {
        if (lottoNumber < LOWER_BOUND_LOTTO || lottoNumber > UPPER_BOUND_LOTTO) {
            throw new IllegalArgumentException("로또 숫자의 유효 범위가 아닙니다.");
        }
    }
}
