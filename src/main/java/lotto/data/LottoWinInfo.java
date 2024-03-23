package lotto.data;

import java.util.Arrays;

import static lotto.util.ConstUtils.MATCHED_COUNT_TO_BE_CHECKED_BONUS;
import static lotto.util.ConstUtils.MINIMUM_WIN_MATCH;

public enum LottoWinInfo {
    WIN_FIRST(6, 2_000_000_000, false),
    WIN_FIRST_WITH_BONUS(5, 30_000_000, true),
    WIN_SECOND(5, 1_500_000, false),
    WIN_THIRD(4, 50_000, false),
    WIN_FOURTH(3, 5_000, false),
    PASS(0, 0, false)
    ;

    private final int matchedCount;
    private final int winningPrice;
    private final boolean withBonus;

    LottoWinInfo(int matchedCount, int winningPrice, boolean withBonus) {
        this.matchedCount = matchedCount;
        this.winningPrice = winningPrice;
        this.withBonus = withBonus;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static LottoWinInfo valueOf(int matchedCount, boolean withBonus) {
        if (matchedCount < MINIMUM_WIN_MATCH) {
            return PASS;
        }

        if (matchedCount == MATCHED_COUNT_TO_BE_CHECKED_BONUS) {
            return getLottoWinInfoOfMatchedFive(withBonus);
        }

        return Arrays.stream(values())
                .filter(win -> win.matchedCount == matchedCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static LottoWinInfo getLottoWinInfoOfMatchedFive(boolean withBonus) {
        if (withBonus) {
            return WIN_FIRST_WITH_BONUS;
        }
        return WIN_SECOND;
    }
}
