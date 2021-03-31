package step2.domain.winning;

import java.util.EnumMap;
import java.util.Map;

public final class WinningResult {

    private final static int ZERO = 0;
    private final static int INCREASE = 1;

    private final Map<WinningScore, Integer> winningScoreBoard;

    private WinningResult(Map<WinningScore, Integer> winningScoreBoard) {
        init(winningScoreBoard);
        this.winningScoreBoard = winningScoreBoard;
    }

    public static WinningResult of() {
        return of(new EnumMap<>(WinningScore.class));
    }

    public static WinningResult of(Map<WinningScore, Integer> winningScore) {
        return new WinningResult(winningScore);
    }

    private final void init(Map<WinningScore, Integer> winningScoreBoard) {
        for (WinningScore winningScore : WinningScore.values()) {
            winningScoreBoard.put(winningScore, ZERO);
        }
    }

    public final void add(int correctCount) {
        WinningScore winningScore = WinningScore.valueOf(correctCount);
        increaseCount(winningScore);
    }

    public final void increaseCount(WinningScore winningScore) {
        winningScoreBoard.put(winningScore, getMatchCount(winningScore) + INCREASE);
    }

    public final int getMatchCount(WinningScore winningScore) {
        return winningScoreBoard.get(winningScore);
    }


}
