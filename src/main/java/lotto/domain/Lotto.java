package lotto.domain;

public class Lotto {

    private LottoNumbers lottoPickNumber;

    public Lotto(LottoMachine lottoMachine) {
        this.lottoPickNumber = lottoMachine.createLottoNumber();
    }

    public PrizeInformation matchPrizeNumber(PrizeLotto prizeLotto) {
        int prizeCount = (int) lottoPickNumber.getLottoNumbers().stream()
                                    .filter(prizeLotto::findByIndexNumber)
                                    .count();
        return PrizeInformation.findByPrizePrice(prizeCount);
    }

    public LottoNumbers getLottoPickNumber() {
        return lottoPickNumber;
    }

}