package lotto.domain.winner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.exception.UnknownWinningConditionException;

public enum WinningCondition {

    MATCH_ZERO(0, 0),
    MATCH_ONE(1, 0),
    MATCH_TWO(2, 0),
    MATCH_THREE(3, 5_000),
    MATCH_FOR(4, 50_000),
    MATCH_FIVE(5, 1_500_000, true, false),
    MATCH_BONUS(5, 30_000_000, true, true),
    MATCH_SIX(6, 2_000_000_000),
    ;

    private final int matchCount;
    private final long prizeMoney;

    private final boolean requiredBonus;
    private final boolean bonusMatch;

    WinningCondition(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.requiredBonus = false;
        this.bonusMatch = false;
    }

    WinningCondition(int matchCount, long prizeMoney, boolean requiredBonus, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.requiredBonus = requiredBonus;
        this.bonusMatch = bonusMatch;
    }

    public static WinningCondition getConditionByMatchCount(int matchCount, boolean bonusMatch) {
        return Arrays.stream(WinningCondition.values())
                .filter(condition ->
                        condition.matchCount == matchCount
                                && checkBonusRule(bonusMatch, condition))
                .findFirst()
                .orElseThrow(UnknownWinningConditionException::new);
    }

    private static boolean checkBonusRule(boolean bonusMatch, WinningCondition condition) {
        return !condition.requiredBonus || condition.bonusMatch == bonusMatch;
    }

    public static List<WinningCondition> getConditionsWithPrize() {
        return Arrays.stream(WinningCondition.values())
                .filter(condition -> condition.prizeMoney > 0)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public boolean getRequiredBonus() {
        return requiredBonus;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }

}
