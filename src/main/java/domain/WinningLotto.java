package domain;

public class WinningLotto {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(String winningNumbers, int bonusNumber) {
        this.winningNumbers = Lotto.manual(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto lotto) {
        int matchNumber = lotto.getMatchNumber(winningNumbers);
        return Rank.valueOf(matchNumber, hasNumber(lotto));
    }

    private boolean hasNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
