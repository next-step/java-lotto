package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoWinningLevel {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    static Map<Integer, LottoWinningLevel> levels = new HashMap<>();

    static {
        levels.put(3, THREE);
        levels.put(4, FOUR);
        levels.put(5, FIVE);
        levels.put(6, SIX);
    }

    private final int matchNumberCount;
    private final int winningPrize;

    LottoWinningLevel(int matchNumberCount, int winningPrize) {
        this.matchNumberCount = matchNumberCount;
        this.winningPrize = winningPrize;
    }

    public static LottoWinningLevel of(int matchCount) {
        return levels.get(matchCount);
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public long getWinningPrize() {
        return winningPrize;
    }
}
