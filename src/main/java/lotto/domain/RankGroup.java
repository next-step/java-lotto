package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public double returnMoneyPercentage(Pay pay) {
        return Math.floor((sumMoney() / (double) pay.getPay()) * SECOND_DIGIT) / SECOND_DIGIT;
    }

    public int getCountOf(Rank inputRank) {
        return rankGroup
                .stream()
                .filter(rank -> rank.equals(inputRank))
                .collect(Collectors.counting())
                .intValue();
    }
}
