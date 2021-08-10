package lotto.model;

public class LottoChecker {
    private final Lotto winningLotto;

    public LottoChecker(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoResult check(Lotto lotto) {
        int correctCount = winningLotto.countCorrect(lotto);

        return LottoResult.from(correctCount);
    }
}
