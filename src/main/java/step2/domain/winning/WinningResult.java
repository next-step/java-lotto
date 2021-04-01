package step2.domain.winning;

import java.util.Map;

public final class WinningResult {

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
