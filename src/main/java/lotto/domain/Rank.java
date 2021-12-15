package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.matchCount = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (isEqualMatchCount(matchCount, SECOND) && matchBonus) {
            return Rank.SECOND;
        }

        return Stream.of(values())
                .filter(matchRank -> isEqualMatchCount(matchCount, matchRank))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static boolean isEqualMatchCount(int matchCount, Rank matchRank) {
        return matchRank.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "countOfMatch=" + matchCount +
                ", winningMoney=" + winningMoney +
                '}';
    }
}
