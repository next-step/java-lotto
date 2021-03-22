package lotto.dto;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN || lottoNumber > LOTTO_MAX) {
            throw new IllegalArgumentException();
        }

        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.getLottoNumber();
    }
}
