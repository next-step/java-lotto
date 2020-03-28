package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(51, 300_000_000),
    SIX(6, 2_000_000_000);

    private static Map<Integer, LottoRank> levels = new HashMap<>();

    static {
        levels.put(0, ZERO);
        levels.put(1, ONE);
        levels.put(2, TWO);
        levels.put(3, THREE);
        levels.put(4, FOUR);
        levels.put(5, FIVE);
        levels.put(51, FIVE_BONUS);
        levels.put(6, SIX);
    }

    private final int matchCount;
    private final int winningPrize;

    LottoRank(int matchCount, int winningPrize) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
    }

    public static LottoRank of(int matchCount) {
        return levels.get(matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
