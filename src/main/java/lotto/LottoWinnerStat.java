package lotto;

public class LottoWinnerStat {
    private final LottoWinners winners;
    private final int ticketCount;

    public LottoWinnerStat(int ticketCount, LottoWinners winners) {
        this.ticketCount = ticketCount;
        this.winners = winners;
    }

    public Long getWinnerCount(LottoWinnerClass winnerClass) {
        return winners.getWinnerCount(winnerClass);
    }

    public double getProfitMargin(LottoPrice price, LottoPrizeInfo prizeInfo) {
        double result = 0.0;
        for (LottoWinnerClass winnerClass : LottoWinnerClass.values()) {
            result += prizeInfo.getPrize(winnerClass) * getWinnerCount(winnerClass);
        }
        return result / price.getPurchasePrice(ticketCount);
    }
}
