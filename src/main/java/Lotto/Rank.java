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

        if (countOfMatch == Rank.FIRST.countOfMatch) {
            return Rank.FIRST;
        }
        if (countOfMatch == Rank.SECOND.countOfMatch && matchBonus) {
            return Rank.SECOND;
        }
        if (countOfMatch == Rank.THIRD.countOfMatch && !matchBonus) {
            return Rank.THIRD;
        }
        if (countOfMatch == Rank.FOURTH.countOfMatch) {
            return Rank.FOURTH;
        }
        if (countOfMatch == Rank.FIFTH.countOfMatch) {
            return Rank.FIFTH;
        }

        return Rank.MISS;
    }
}
