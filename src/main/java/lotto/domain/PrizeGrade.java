package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PrizeGrade {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(4, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int prizeMoney;

    PrizeGrade(int matchCount, boolean isBonusMatch, int prizeMoney) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static PrizeGrade getPrizeGrade(int matchCount, boolean isBonusMatch) {
        if (matchCount == PrizeGrade.SECOND.getMatchCount() && isBonusMatch) {
            return SECOND;
        }

        List<PrizeGrade> prizeGradeCandidate = Arrays.stream(values())
            .filter(prizeGrade -> prizeGrade.matchCount == matchCount)
            .filter(prizeGrade -> prizeGrade.isBonusMatch == false)
            .collect(Collectors.toList());

        if (prizeGradeCandidate.size() > 0) {
            return prizeGradeCandidate.get(0);
        }
        return NONE;
    }
}
