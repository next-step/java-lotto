package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN) {
            throw new IllegalArgumentException("로또 번호는 1 이상 입니다.");
        }

        if (lottoNumber > LOTTO_MAX) {
            throw new IllegalArgumentException("로또 번호는 45이하 입니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return o.lottoNumber - this.lottoNumber;
    }
}
