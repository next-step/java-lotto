package autolotto.domain;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;
    private int[] matchCounts;
    private int ticketsCount;

    public LottoStatistics(int[] matchCounts, int ticketsCount) {
        this.matchCounts = matchCounts;
        this.ticketsCount = ticketsCount;
    }

    public double calculateProfit(int[] matchCounts, int ticketsCount) {
        int totalPrize = matchCounts[3] * 5000 + matchCounts[4] * 50000
                + matchCounts[5] * 1500000 + matchCounts[6] * 2000000000;
        return (double) totalPrize / (ticketsCount * LOTTO_PRICE);
    }
}
