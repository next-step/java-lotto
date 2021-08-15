package lotto.model;

public class LottoChecker {
    private final Lotto winningLotto;

    public LottoChecker(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoPlace check(Lotto lotto) {
        int correctCount = winningLotto.countCorrect(lotto);

        return LottoPlace.fromCorrectCount(correctCount);
    }
}
