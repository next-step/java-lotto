package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum MatchingCount {

    FIRST(6, Ranking.FIRST_CLASS),
    SECOND(5, Ranking.SECOND_CLASS),
    THIRD(4, Ranking.THIRD_CLASS),
    FOURTH(3, Ranking.FOURTH_CLASS),
    ZERO(0, Ranking.ZERO_CLASS);

    int count;
    Ranking rank;

    private static Map mappingByCountMatching = new HashMap<>();

    MatchingCount(int matchingCount, Ranking ranking) {
        this.count = matchingCount;
        this.rank = ranking;
    }

    static {
        for (MatchingCount matchingCount : MatchingCount.values()) {
            mappingByCountMatching.put(matchingCount.count, matchingCount);
        }
    }

    public static MatchingCount valueOf(int matchCount) {
        MatchingCount matchingCount = (MatchingCount) mappingByCountMatching.get(matchCount);

        if (matchingCount == null){
            throw new IllegalArgumentException("Not Enum constant was found for matchCount : " + matchCount);
        }

        return matchingCount;
    }

    public Ranking getRank() {
        return this.rank;
    }
}
