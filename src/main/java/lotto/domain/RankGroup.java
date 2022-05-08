package lotto.domain;

import java.util.List;

public class RankGroup {
    private static final int SECOND_DIGIT = 100;
    private final List<Rank> rankGroup;

    public RankGroup(List<Rank> rankList) {
        this.rankGroup = rankList;
    }

    public int sumMoney() {
        int totalMoney = 0;

        for (Rank rank : rankGroup) {
            totalMoney = rank.addMoney(totalMoney);
        }

        return totalMoney;
    }

    public int getCountOfMatchCount(int matchCount) {
        int count = 0;
        for (Rank rank : rankGroup) {
            count = getCount(matchCount, count, rank);
        }
        return count;
    }

    private int getCount(int matchCount, int count, Rank rank) {
        if (rank.isSameMatchCount(matchCount)) {
            count++;
        }
        return count;
    }

    public double returnMoneyPercentage(int totalTicketPrice) {
        return Math.floor((sumMoney() / (double) totalTicketPrice) * SECOND_DIGIT) / SECOND_DIGIT;
    }
}
