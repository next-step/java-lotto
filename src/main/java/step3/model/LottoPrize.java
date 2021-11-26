package step3.model;

public class LottoPrize {

    private static final double DEFAULT_YIELD = 0.0;

    private final LottoWin lottoWin;
    private final Money insertedMoney;

    public LottoPrize(LottoWin lottoWin, Money insertedMoney) {
        this.lottoWin = lottoWin;
        this.insertedMoney = insertedMoney;
    }

    public LottoWin getLottoWin() {
        return lottoWin;
    }

    public double totalYield() {
        if (!insertedMoney.ableToYield()) {
            return DEFAULT_YIELD;
        }
        return (double) totalReward().won() / insertedMoney.won();
    }

    private Money totalReward() {
        return lottoWin.totalReward();
    }

}
