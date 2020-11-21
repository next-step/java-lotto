package lotto.domain;

public class Lotto {

    private LottoNumbers lottoPickNumber;

    public Lotto(LottoNumbers lottoPickNumber) {
        this.lottoPickNumber = lottoPickNumber;
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int prizeCount = lottoPickNumber.countPrizeMatchLottoNumber(prizeLotto);
        return PrizeInformation.findByPrizePrice(prizeCount);
    }

    public LottoNumbers getLottoPickNumber() {
        return lottoPickNumber;
    }

}