package lotto.domain;

import lotto.vo.LottoMatchCount;

public class LottoProfit {
    private double profit;

    private int buyAutoCount;

    private int buyDirectCount;

    private int buyAmount;

    private int changeAmount;

    public LottoProfit(int buyDirectCount, int buyAmount) {
        this.profit = 0.0d;
        this.buyAutoCount = (buyAmount - (buyDirectCount * Lotto.LOTTO_PRICE)) / Lotto.LOTTO_PRICE;
        this.buyDirectCount = buyDirectCount;
        this.buyAmount = buyAmount;
        this.changeAmount = buyAmount - (this.buyAutoCount + buyDirectCount) * Lotto.LOTTO_PRICE;
    }

    /**
     * 수익율 개산
     */
    public void calculateProfit(LottoMatchCount lottoMatchCount) {
        profit = (LottoPrize.FIFTH.getPrize() * lottoMatchCount.getFifthCnt()
                + LottoPrize.FORTH.getPrize() * lottoMatchCount.getForthCnt()
                + LottoPrize.THIRD.getPrize() * lottoMatchCount.getThirdCnt()
                + LottoPrize.SECOND.getPrize() * lottoMatchCount.getSecondCnt()
                + LottoPrize.FIRST.getPrize() * lottoMatchCount.getFirstCnt())
                /
                ((buyAmount - changeAmount) * 1.0d);
    }

    public double getProfit() {
        return profit;
    }

    public int getBuyAutoCount() {
        return buyAutoCount;
    }

    public int getBuyDirectCount() {
        return buyDirectCount;
    }
}
