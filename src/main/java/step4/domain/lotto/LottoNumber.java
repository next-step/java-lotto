package step4.domain.lotto;

public class LottoNumber {
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

}
