package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchingScore;
    private final int profit;

    Rank(int matchingScore, int profit) {
        this.matchingScore = matchingScore;
        this.profit = profit;
    }

    public int getMatchingScore() {
        return matchingScore;
    }

    public int getProfit() {
        return profit;
    }

    public static Rank getRankByMatchingScore(int countOfMatch, boolean matchBonus) {

        if (getBonusRank(countOfMatch, matchBonus)) return SECOND;

        return bonusNotMatchedRank().stream()
                .filter(r -> r.getMatchingScore() == countOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(countOfMatch + "개 일치한 경우는 없습니다."));
    }

    private static boolean getBonusRank(int countOfMatch, boolean matchBonus) {
        return countOfMatch == 5 && matchBonus;
    }

    public static List<Rank> bonusNotMatchedRank() {
        return Arrays.asList(FIRST, THIRD, FOURTH, FIFTH);
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return getMatchingScore() +
                    "개 일치, 보너스 볼 일치 (" + getProfit() + "원)" + ": ";
        }
       return getMatchingScore() +
                "개 일치 (" + getProfit() + "원)" + ": ";
    }
}
