package lotto.domain;

import java.util.List;

public class LottoStatistic {
    private static final String RANK_FOUR_REWARD_MESSAGE = "3개 일치 (5000원)- %d개\n";
    private static final String RANK_THIRD_REWARD_MESSAGE = "4개 일치 (50000원)- %d개\n";
    private static final String RANK_SECOND_REWARD_MESSAGE = "5개 일치 (1500000원)- %d개\n";
    private static final String RANK_FIRST_REWARD_MESSAGE = "6개 일치 (2000000000원)- %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int PURCHASE_UNIT = 1000;

    private int firstRankCount;
    private int secondRankCount;
    private int thirdRankCount;
    private int fourRankCount;
    private int lottCount;

    public LottoStatistic(List<Integer> matchCounts, LottoCount lottoCount) {
        lottCount = lottoCount.count();
        for (int matchCount : matchCounts) {
            setRankCount(matchCount);
        }
    }

    private void setRankCount(int matchCount) {
        Rank rank = Rank.valueOfRank(matchCount);
        setFirstRankCount(rank);
        setSecondRankCount(rank);
        setThirdRankCount(rank);
        setFourRankCount(rank);
    }

    private void setFourRankCount(Rank rank) {
        if (rank.isFour()) {
            fourRankCount++;
        }
    }

    private void setThirdRankCount(Rank rank) {
        if (rank.isThird()) {
            thirdRankCount++;
        }
    }

    private void setSecondRankCount(Rank rank) {
        if (rank.isSecond()) {
            secondRankCount++;
        }
    }

    private void setFirstRankCount(Rank rank) {
        if (rank.isFirst()) {
            firstRankCount++;
        }
    }

    public StringBuilder message() {
        StringBuilder message = new StringBuilder();
        message.append(String.format(RANK_FOUR_REWARD_MESSAGE, fourRankCount));
        message.append(String.format(RANK_THIRD_REWARD_MESSAGE, thirdRankCount));
        message.append(String.format(RANK_SECOND_REWARD_MESSAGE, secondRankCount));
        message.append(String.format(RANK_FIRST_REWARD_MESSAGE, firstRankCount));
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
        return (firstRankCount * Rank.FIRST.getMoney())
                + (secondRankCount * Rank.SECOND.getMoney())
                + (thirdRankCount * Rank.THIRD.getMoney())
                + (fourRankCount * Rank.FOUR.getMoney());


    }

}
