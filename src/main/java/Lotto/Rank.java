package Lotto;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank returnRank = null;

        if (countOfMatch == Rank.FIRST.countOfMatch) {
            returnRank = Rank.FIRST;
        } else if (countOfMatch == Rank.SECOND.countOfMatch && matchBonus) {
            returnRank = Rank.SECOND;
        } else if (countOfMatch == Rank.THIRD.countOfMatch && !matchBonus) {
            returnRank = Rank.THIRD;
        } else if (countOfMatch == Rank.FOURTH.countOfMatch) {
            returnRank = Rank.FOURTH;
        } else if (countOfMatch == Rank.FIFTH.countOfMatch) {
            returnRank = Rank.FIFTH;
        } else if (countOfMatch < Rank.FIFTH.countOfMatch) {
            returnRank = Rank.MISS;
        }

        return returnRank;
    }
}
