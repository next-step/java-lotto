package lotto.domain.prize;


public class EarningRatio {

    private final float ratio;

    public EarningRatio(LottoMatch lottoMatch, int purchaseMoney) {
        ratio = calculateEarningRatio(lottoMatch, purchaseMoney);
    }

    public float calculateEarningRatio(LottoMatch lottoMatch, int purchaseMoney) {
        return (float) calculateEarnMoney(lottoMatch) / purchaseMoney;
    }

    private int calculateEarnMoney(LottoMatch lottoMatch) {
        return lottoMatch.calculateEarnMoney();
    }

    public float getRatio() {
        return ratio;
    }
}
