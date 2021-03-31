package step2.domain.winning;

import java.util.EnumMap;
import java.util.Map;

public final class WinningResult {

    private final static int ZERO = 0;
    private final static int INCREASE = 1;

    private final Map<WinningScore, Integer> winningScoreBoard;

    private WinningResult(Map<WinningScore, Integer> winningScoreBoard) {
        this.winningScoreBoard = winningScoreBoard;
    }

    public static WinningResult of(Map<WinningScore, Integer> winningScore) {
        return new WinningResult(winningScore);
    }

    public final int getMatchCount(WinningScore winningScore) {
        return winningScoreBoard.get(winningScore);
    }

}
