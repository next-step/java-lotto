package lotto.model;

public class LottoStatistics {
    public int buyLottos(int budget) {
        int purchase =  budget / Lotto.LOTTO_PRICE;

        return purchase;
    }

    public int getPrizeMoney(Lotto.Rank rank) {
        return rank.getPrize();
    }

    public double calcProfit(double prize, double budget) {
        return Math.floor(prize / budget * 100) / 100.0;
    }
}
