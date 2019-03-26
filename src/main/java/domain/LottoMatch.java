package domain;

public class LottoMatch {
    private WinningNumbers winningNumbers;

    public LottoMatch(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoRank matchResult(Lotto lotto) {
        return LottoRank.findMatchCount(this.calculateMatchCount(lotto), this.calculateMatchResult(lotto));
    }

    private int calculateMatchCount(Lotto lotto) {
        return this.winningNumbers.calcMatchCount(lotto);
    }

    private boolean calculateMatchResult(Lotto lotto) {
        return this.winningNumbers.isContainsBonusBall(lotto);
    }

}

