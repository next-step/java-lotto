package lotto.domain;

import java.util.Arrays;

@FunctionalInterface
interface PrizeGradeMatcher {

    boolean findPrizeGrade(int matchCount, boolean matchBonus);
}

public enum PrizeGrade {
    NONE(0, 0, (matchCount, matchBonus) -> matchCount == 0),
    FIFTH(5_000, 3, (matchCount, matchBonus) -> matchCount == 3),
    FOURTH(50_000, 4, (matchCount, matchBonus) -> matchCount == 4),
    THIRD(1_500_000, 5, (matchCount, matchBonus) -> matchCount == 5),
    SECOND(30_000_000, 5, (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    FIRST(2_000_000_000, 6, (matchCount, matchBonus) -> matchCount == 6);

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private final int prizeMoney;
    private final int matchCount;
    private final PrizeGradeMatcher prizeGradeMatcher;

    PrizeGrade(int prizeMoney, int matchCount, PrizeGradeMatcher prizeGradeMatcher) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.prizeGradeMatcher = prizeGradeMatcher;
    }

    public static PrizeGrade of(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(values())
            .filter(prizeGrade -> prizeGrade.prizeGradeMatcher.findPrizeGrade(matchCount, isBonusMatch))
            .findFirst()
            .orElse(NONE);
    }
}
