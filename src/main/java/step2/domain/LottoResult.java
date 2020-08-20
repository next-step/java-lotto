package step2.domain;

public class LottoResult {

    private int winningNumbersCount;

    public LottoResult(int winningNumbersCount) {
        this.winningNumbersCount = winningNumbersCount;
    }

    public boolean isWinningNumbersCount(int winningNumbersCount) {
        return this.winningNumbersCount == winningNumbersCount;
    }

}
