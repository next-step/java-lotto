package lotto.domain;

import java.util.Arrays;

public enum MatchingCount {
    FIRST(6, Ranking.FIRST_CLASS),
    SECOND(5, Ranking.SECOND_CLASS),
    THIRD(4, Ranking.THIRD_CLASS),
    FOURTH(3, Ranking.FOURTH_CLASS),
    ZERO(0, Ranking.ZERO_CLASS);


    private static final int MINIMUM_MATCH_LOTTO = 3;
    int count;
    Ranking rank;

    MatchingCount(int matchingCount, Ranking ranking) {
        this.count = matchingCount;
        this.rank = ranking;
    }

    public static MatchingCount valueOf(int matchCount) {
        return Arrays.stream(MatchingCount.values())
                .filter(e -> e.count == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Enum constant was found for matchCount : " + matchCount));
    }

    public static Ranking getRank(int count) {
        if (count < MINIMUM_MATCH_LOTTO) {
            return MatchingCount.valueOf(0).rank;
        }

        return MatchingCount.valueOf(count).rank;
    }
}
