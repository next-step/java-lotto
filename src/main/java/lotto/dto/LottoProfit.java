package lotto.dto;

import lotto.domain.LottoPrize;

public class LottoProfit {
    private double profit;

    private int buyCount;

    private int buyAmount;

    private int changeAmount;

    public LottoProfit(int buyCount, int buyAmount) {
        this.profit = 0.0d;
        this.buyCount = buyCount;
        this.buyAmount = buyAmount;
        this.changeAmount = buyAmount - buyCount * Lotto.LOTTO_PRICE;
    }

    /**
     * 수익율 개산
     */
    public void calculateProfit(int forthCnt, int thirdCnt, int secondCnt, int firstCnt) {
        profit = (LottoPrize.FORTH.getPrize() * forthCnt
                + LottoPrize.THIRD.getPrize() * thirdCnt
                + LottoPrize.SECOND.getPrize() * secondCnt
                + LottoPrize.FIRST.getPrize() * firstCnt)
                /
                ((buyAmount - changeAmount) * 1.0d);
    }

    public double getProfit() {
        return profit;
    }

    public int getBuyCount() {
        return buyCount;
    }
}
