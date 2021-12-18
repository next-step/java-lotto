package step2.domain;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.stream.Stream;

public enum WinningCondition {
    WIN_NONE(0, 0),
    WIN_5TH(3, 5_000),
    WIN_4TH(4, 50_000),
    WIN_3TH(5, 1_500_000),
    WIN_2TH(5, 30_000_000),
    WIN_1TH(6, 2_000_000_000),
    ;

    private final long matchedCondition;
    private final long winningPrize;

    WinningCondition(int matchedCondition, long winningPrize) {
        this.matchedCondition = matchedCondition;
        this.winningPrize = winningPrize;
    }

    public static WinningCondition calculateWinningRank(long matchedCount, boolean bonusNumber) {

        return Arrays.stream(WinningCondition.values())
                .filter(condition -> condition.matchedCondition == matchedCount)
                .findFirst()
                .map(condition -> {
                    return gradedCondition(bonusNumber, condition);
                })
                .orElse(WIN_NONE);
    }

    private static WinningCondition gradedCondition(boolean bonusNumber, WinningCondition condition) {
        if(condition.equals(WIN_3TH) && bonusNumber) {
            return WIN_2TH;
        }

        return condition;
    }

    public long getMatchedCondition() {
        return matchedCondition;
    }

    public long getWinningPrize() {
        return winningPrize;
    }
}
