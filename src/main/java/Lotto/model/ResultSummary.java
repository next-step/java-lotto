package Lotto.model;

import java.util.Map;

public class ResultSummary {

    private static final int DEFAULT_VALUE = 0;
    private Map<Rank, Integer> countingRank;


    public ResultSummary(Lottos lottos, LuckyNumber luckyNumber) {
        this.countingRank = lottos.summaryLottoResult(luckyNumber);
    }

    public double getProfit(LottoBuyResource lottoBuyResource) {
        double reward = 0;
        int count = 0;
        double price = lottoBuyResource.getLottoPrice();
        for (Rank rank : countingRank.keySet()) {
            count += countingRank.get(rank);
            reward += rank.getReward() * countingRank.get(rank);
        }
        if (count == 0) {
            return 0;
        }
        return reward / price;
    }

    public int getCountNumber(Rank rank) {
        return countingRank.getOrDefault(rank, DEFAULT_VALUE);
    }

}
