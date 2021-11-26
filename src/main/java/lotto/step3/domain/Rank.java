package lotto.step3.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int prizeMoney;

    Rank(int countOfMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank rank(int count, boolean matchBonusBall) {
        if (count < Rank.FIFTH.countOfMatch) {
            return Rank.MISS;
        }
        if (SECOND.isCountOfMatch(count)) {
            return rankSecondAndThird(matchBonusBall);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.isCountOfMatch(count))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private static Rank rankSecondAndThird(boolean matchBonusBall) {
        if (matchBonusBall) {
            return SECOND;
        }
        return THIRD;
    }

    private boolean isCountOfMatch(int count) {
        return this.countOfMatch == count;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "countOfMatch=" + countOfMatch +
                ", prizeMoney=" + prizeMoney +
                '}';
    }

}
