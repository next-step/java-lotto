package lotto.model;

public class LottoStatistics {
    public int buyLottos(int budget) {
        int purchase =  budget / Lotto.LOTTO_PRICE;

        return purchase;
    }

    public int getPrizeMoney(Lotto.Rank rank) {
        if (rank == null) {
            return 0;
        }

        return rank.getPrize();
    }

    public double calcProfit(double prize, double budget) {
        return Math.floor(prize / budget * 100) / 100.0;
    }

    public void gatherResult(Lotto.Rank rank) {
        rank.plusCount();
    }
}
