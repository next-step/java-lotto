package lotto.model;

public class WinningResult {

    private static final double SECOND_DECIMAL = 100.0;
    private final RankResult rankResult;
    private final double profit;

    private WinningResult(final RankResult rankResult, final double profit) {
        this.rankResult = rankResult;
        this.profit = profit;
    }

    public static WinningResult of(final WinningLotto winningLotto, final PurChasedLottos purChasedLottos) {
        RankResult rankResult = new RankResult();
        for (var purchasedLotto : purChasedLottos.getLottos()) {
            Rank rank = winningLotto.matchOfRank(purchasedLotto);
            rankResult.plusCountOfRank(rank);
        }
        return new WinningResult(
                rankResult,
                calculateProfit(rankResult.getTotalRankReward(), purChasedLottos.getMoney()));
    }

    private static double calculateProfit(final int totalRankReward, final int money) {
        return floorSecondDecimal((double) totalRankReward / money);
    }

    private static double floorSecondDecimal(final double profit) {
        return Math.floor(profit * SECOND_DECIMAL) / SECOND_DECIMAL;
    }

    public int getCountOfRank(final Rank rank) {
        return rankResult.getCountOfRank(rank);
    }

    public double getProfit() {
        return profit;
    }

}
