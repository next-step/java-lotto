package lotto.core.round;

import lombok.Getter;

@Getter
public enum Rank {
    FIRST(6, 1500000000),
    SECOND(5, 50000000),
    THIRD(5, 1300000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == FIFTH.getCountOfMatch()) {
            return FIFTH;
        }
        if (countOfMatch == FOURTH.getCountOfMatch()) {
            return FOURTH;
        }
        if (countOfMatch == SECOND.getCountOfMatch()) {
            return matchBonus ? SECOND : THIRD;
        }
        if (countOfMatch == FIRST.getCountOfMatch()) {
            return FIRST;
        }

        return MISS;
    }
}
