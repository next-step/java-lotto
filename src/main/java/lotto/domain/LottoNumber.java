package lotto.domain;

public class LottoNumber {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN) {
            throw new IllegalArgumentException("로또 번호는 1 이상입니다.");
        }

        if (lottoNumber > LOTTO_MAX) {
            throw new IllegalArgumentException("로또 번호는 45 이하입니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    public int toInt() {
        return lottoNumber;
    }
}
