package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Prize matches(Lotto lotto) {
        int countOfMatchingNumbers = this.lotto.getCountOfMatchingNumbers(lotto);
        boolean hasBonusNumber = lotto.contains(this.bonusNumber);

        return Prize.valueOf(countOfMatchingNumbers, hasBonusNumber);
    }
}
