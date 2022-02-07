package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    OTHERS(0, 0, 0);

    private final int numberOfMatches;
    private final int prizeMoney;
    private final int bonus;
    private int count = 0;

    Ranking(final int numberOfMatches, int bonus, final int prizeMoney) {
        this.numberOfMatches = numberOfMatches;
        if (numberOfMatches == 5) {
            this.bonus = bonus;
        } else {
            this.bonus = 0;
        }
        this.prizeMoney = prizeMoney;
    }

    public static Ranking of(final int numberOfMatches, final int bonus) {
        return Arrays.stream(values())
            .filter(
                Ranking -> (Ranking.numberOfMatches == numberOfMatches) &&
                    (Ranking.bonus == bonus))
            .findAny()
            .orElse(OTHERS);
    }

    public void addWinningCount() {
        count++;
    }

    public int operate() {
        return prizeMoney * count;
    }


    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getBonus() {
        return bonus;
    }

    public int getCount() {
        return count;
    }

}
