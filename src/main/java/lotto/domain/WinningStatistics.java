package lotto.domain;

import java.util.Map;
import java.util.function.ToLongFunction;

public class WinningStatistics {

    private final Map<LottoRank, Integer> rankCountMap = LottoRank.makeRankMap();
    private final int purchasedTicketCount;

    public WinningStatistics(int purchasedTicketCount) {
        this.purchasedTicketCount = purchasedTicketCount;
    }

    public void addMatchedCount(LottoRank lottoRank) {
        addCountByWinningReward(lottoRank);
    }

    private void addCountByWinningReward(LottoRank lottoRank) {
        int currentCount = rankCountMap.getOrDefault(lottoRank, 0);
        rankCountMap.put(lottoRank, currentCount + 1);
    }

    public double getIncomeRate() {
        long purchasedAmount = getPurchasedAmount();
        long rewardAmount = getRewardAmount();
        return calculateIncomeRate(rewardAmount, purchasedAmount);
    }

    private long getPurchasedAmount() {
        return purchasedTicketCount * (long) PurchasedAmount.LOTTO_PRICE;
    }

    private long getRewardAmount() {
        return rankCountMap.entrySet()
                .stream()
                .mapToLong(toRewardAmount())
                .sum();
    }

    private ToLongFunction<Map.Entry<LottoRank, Integer>> toRewardAmount() {
        return e -> e.getKey().getReward() * e.getValue();
    }

    private double calculateIncomeRate(long rewardAmount, long purchasedAmount) {
        double incomeRate = (double) rewardAmount / purchasedAmount;
        return Double.parseDouble(String.format("%.2f", incomeRate));
    }

    public int getCountByRank(LottoRank lottoRank) {
        return rankCountMap.get(lottoRank);
    }

}