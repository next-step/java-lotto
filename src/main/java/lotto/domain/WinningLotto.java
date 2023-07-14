package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final Ball bonusBall;

    public WinningLotto(final Lotto winningLotto, final Ball bonusBall) {
        validate(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    private void validate(final Lotto lotto, final Ball bonusBall) {
        if (lotto.containsBall(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼이 중복됩니다.");
        }
    }

    public WinningCriteria match(final Lotto lotto) {
        final int matchCount = lotto.matchCount(this.winningLotto);
        final boolean isMatchedBonusBall = lotto.containsBall(this.bonusBall);

        return WinningCriteria.winningResult(matchCount, isMatchedBonusBall);
    }
}
