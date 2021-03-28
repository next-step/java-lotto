package step2.domain.winning;

import java.util.Map;

public class WinningScoreBoard {

    private final Map<WinningScore, Integer> winningScoreBoard;
    private final int ZERO = 0;
    private final int INCREASE = 1;

    public static WinningScoreBoard newInstance(Map<WinningScore, Integer> winningScore) {
        return new WinningScoreBoard(winningScore);
    }

    private WinningScoreBoard(Map<WinningScore, Integer> winningScoreBoard) {
        init(winningScoreBoard);
        this.winningScoreBoard = winningScoreBoard;
    }

    private void init(Map<WinningScore, Integer> winningScoreBoard) {
        for(WinningScore winningScore: WinningScore.values()){
            winningScoreBoard.put(winningScore, ZERO);
        }
    }

    public final void increaseCount(WinningScore winningScore) {
        winningScoreBoard.put(winningScore, get(winningScore)+INCREASE);
    }

    public final int get(WinningScore winningScore) {
        return winningScoreBoard.get(winningScore);
    }

}
