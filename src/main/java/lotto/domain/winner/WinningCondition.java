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
    MATCH_FIVE(5, 1_500_000),
    MATCH_SIX(6, 2_000_000_000),
    ;

    private final int matchCount;
    private final int prizeMoney;

    WinningCondition(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningCondition getConditionByMatchCount(int matchCount) {
        return Arrays.stream(WinningCondition.values())
                .filter(condition -> condition.matchCount == matchCount)
                .findFirst()
                .orElseThrow(UnknownWinningConditionException::new);
    }

    public static List<WinningCondition> getConditionsWithPrize() {
        return Arrays.stream(WinningCondition.values())
                .filter(condition -> condition.prizeMoney > 0)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
