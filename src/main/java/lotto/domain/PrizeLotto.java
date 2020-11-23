package lotto.domain;

public class PrizeLotto  {

    private LottoNumbers prizeNumbers;

    public PrizeLotto(LottoNumbers prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public boolean findByIndexNumber(int lottoNumber) {
        return prizeNumbers.getLottoNumbers()
                            .contains(lottoNumber);
    }

}