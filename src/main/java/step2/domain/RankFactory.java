package step2.domain;

import step2.Rank;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RankFactory {
    private static final int MINIMUM_RANK_MATCH = Rank.FIFTH.getMatchingCount();

    public static List<Rank> valuesOnlyExactMatch() {
        return Arrays.stream(Rank.values()) //
                .filter(Rank::isExactMatch) //
                .collect(toList());
    }

    static int getAvailableMatchCount(int matchCount) {
        if (matchCount < MINIMUM_RANK_MATCH) {
            return 0;
        }
        return matchCount;
    }

    public static Rank valueFrom(int matchCount) {
        int availableMatchCount = getAvailableMatchCount(matchCount);
        return valuesOnlyExactMatch() //
                .stream()
                .filter(value -> value.getMatchingCount() == availableMatchCount) //
                .findFirst() //
                .orElseThrow(OutOfMatchingBoundaryException::new);
    }

    public static Rank valueWithBonusNumberFrom(int matchCount) {
        if (matchCount == Rank.SECOND.getMatchingCount()) {
            return Rank.SECOND;
        }
        return valueFrom(matchCount);
    }
}
