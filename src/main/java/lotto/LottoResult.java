package lotto;

import java.util.HashMap;

public class LottoResult {
    private HashMap<Rank, Integer> ranking = new HashMap<>();

    public LottoResult() {
        for(Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }
    }

    void setRankingStatus(Rank rank) {
        ranking.put(rank, ranking.get(rank) + 1);
    }

    Integer getRankingCount(Rank rank) {
        return ranking.get(rank);
    }

    double profitRate(int lottoCost) {
        return Double.parseDouble(String.format("%.2f", (totalPrice() / (double)lottoCost)));
    }

    private int totalPrice() {
        int total = 0;
        for(Rank key : ranking.keySet()) {
            total += (ranking.get(key) * key.getWinningMoney());
        }
        return total;
    }
}
