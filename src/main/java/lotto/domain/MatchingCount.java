package lotto.domain;

import java.util.Arrays;

public enum MatchingCount {
    FIRST(6, Ranking.FIRST_CLASS),
    SECOND(5, Ranking.SECOND_CLASS),
    THIRD(5, Ranking.THIRD_CLASS),
    FOURTH(4, Ranking.FOURTH_CLASS),
    FIFTH(3, Ranking.FIFTH_CLASS),
    ZERO(0, Ranking.ZERO_CLASS);


    private static final int MINIMUM_MATCH_LOTTO = 3;
    private static final int MATCHING_FIFTH_COUNT = 5;
    int count;
    Ranking rank;

    MatchingCount(int matchingCount, Ranking ranking) {
        this.count = matchingCount;
        this.rank = ranking;
    }

    public static MatchingCount valueOf(int matchCount) {
        return Arrays.stream(MatchingCount.values())
                .filter(e -> e.count == matchCount)
                .filter(f -> f.rank != Ranking.SECOND_CLASS)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Enum constant was found for matchCount : " + matchCount));
    }

    public static Ranking getRank(int count, boolean hasBonusNumber) {
        if (count < MINIMUM_MATCH_LOTTO) {
            return MatchingCount.ZERO.rank;
        }

        if(isMatchingFifth(count) && hasBonusNumber) {
            return MatchingCount.SECOND.rank;
        }

        return MatchingCount.valueOf(count).rank;
    }

    public static boolean isMatchingFifth(int count) {
        if (count == MATCHING_FIFTH_COUNT) {
           return true;
        }

        return false;
    }
}
