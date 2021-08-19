package lotto.model;

public class LottoChecker {
    private final WinningNumbers winningNumbers;

    public LottoChecker(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoPlace check(Lotto lotto) {
        int correctCount = winningNumbers.countCorrect(lotto);
        boolean correctBonus = winningNumbers.correctBonus(lotto);

        return LottoPlace.decidePlace(correctCount, correctBonus);
    }
}
