package lotto.domain;

public class MatchingMachine {
    private final Lotto lotto;
    private final WinningNumbers winningNumbers;
    private final MatchCriteria matchCriteria;

    public MatchingMachine(Lotto lotto, WinningNumbers winningNumbers, MatchCriteria matchCriteria) {
        this.lotto = lotto;
        this.winningNumbers = winningNumbers;
        this.matchCriteria = matchCriteria;
    }

    public void match() {
        lotto.match(winningNumbers.numberGroup());
    }
}
