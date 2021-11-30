package step2.domain.dto;

public class LottoWinningResult {
    private boolean win;
    private int numberOfMatches;
    private int prizeMoney;

    public LottoWinningResult(boolean win, int numberOfMatches, int prizeOf) {
        this.win = win;
        this.numberOfMatches = numberOfMatches;
        this.prizeMoney = prizeOf;
    }

    public boolean isWin() {
        return win;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
