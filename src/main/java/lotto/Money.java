package lotto;

import java.util.Map;

public class Money {

    private final int money;
    private int TICKET_PRICE = 1_000;

    public Money(int money) {
        this.money = money;
    }


    public int getBuyTicketsCount() {
        return this.money / TICKET_PRICE;
    }



    public int getTotalPrize(Map<LottoRank, Integer> lotteryResults) {
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            int money = totalPrizeCalculator(rank, lotteryResults.get(rank));
            totalPrize += money;
        }
        return totalPrize;
    }

    private int totalPrizeCalculator(LottoRank rank, Integer integer) {
        return rank.getWinningMoney() * integer;
    }

    public double getProfit(LotteryResults lotteryResults) {
        Map<LottoRank, Integer> lottoResults = lotteryResults.getLottoResults();
        int totalPrice = getTotalPrize(lottoResults);
        return totalPrice / (double)money;
    }


}
