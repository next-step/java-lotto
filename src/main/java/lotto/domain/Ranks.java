package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ranks {
    private static final int SECOND_DIGIT = 100;
    private final List<Rank> ranks;

    public Ranks(List<Rank> rankList) {
        this.ranks = rankList;
    }

    public int sumMoney() {
        int totalMoney = 0;
        for (Rank rank : ranks) {
            totalMoney = rank.addMoney(totalMoney);
        }
        return totalMoney;
    }

    public double returnMoneyPercentage(Pay pay) {
        return Math.floor((sumMoney() / (double) pay.getPay()) * SECOND_DIGIT) / SECOND_DIGIT;
    }

    public int getCountOf(Rank inputRank) {
        return ranks
                .stream()
                .filter(rank -> rank.equals(inputRank))
                .collect(Collectors.counting())
                .intValue();
    }
}
