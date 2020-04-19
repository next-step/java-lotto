package lotto.domain;

public class LottoNumber {

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }
}
