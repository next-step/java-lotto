package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {
    private static final String RANK_FOUR_REWARD_MESSAGE = "3개 일치 (5000원)- %d개\n";
    private static final String RANK_THIRD_REWARD_MESSAGE = "4개 일치 (50000원)- %d개\n";
    private static final String RANK_SECOND_REWARD_MESSAGE = "5개 일치 (1500000원)- %d개\n";
    private static final String RANK_FIRST_REWARD_MESSAGE = "6개 일치 (2000000000원)- %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int PURCHASE_UNIT = 1000;

    private int lottCount;
    private Map<Rank, Integer> rankCount = new HashMap<>();

    public LottoStatistic(List<Integer> matchCounts, LottoCount lottoCount) {
        lottCount = lottoCount.count();
        setRankCount(matchCounts);
    }

    public void setRankCount(List<Integer> matchCounts) {
        for (int count : matchCounts) {
            Rank rank = Rank.valueOfRank(count);
            if (rankCount.get(rank) == null) {
                rankCount.put(rank, 1);
                continue;
            }
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
    }

    public StringBuilder message() {
        StringBuilder message = new StringBuilder();
        message.append(String.format(RANK_FOUR_REWARD_MESSAGE, (rankCount.get(Rank.FOUR) == null) ? 0 : rankCount.get(Rank.FOUR)));
        message.append(String.format(RANK_THIRD_REWARD_MESSAGE, (rankCount.get(Rank.THIRD) == null) ? 0 : rankCount.get(Rank.THIRD)));
        message.append(String.format(RANK_SECOND_REWARD_MESSAGE, (rankCount.get(Rank.SECOND) == null) ? 0 : rankCount.get(Rank.SECOND)));
        message.append(String.format(RANK_FIRST_REWARD_MESSAGE, (rankCount.get(Rank.FIRST) == null) ? 0 : rankCount.get(Rank.FIRST)));
        message.append(profitMessage());
        return message;
    }

    public String profitMessage() {
        return String.format(PROFIT_RATE_MESSAGE, calculateProfitRate());
    }

    public double calculateProfitRate() {
        return getTotalReward() / (lottCount * PURCHASE_UNIT);
    }

    public int getTotalReward() {
        int total = 0;
        for (Rank rank : rankCount.keySet()) {
            total += rankCount.get(rank) * rank.getMoney();
        }
        return total;
    }

}
