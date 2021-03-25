package step2.domain.Lotto;

public class LottoNumber {

    private final Integer lottoNumber;

    private LottoNumber(int lottoNumber){
        this(Integer.valueOf(lottoNumber));
    }

    private LottoNumber(Integer lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

}
