package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String lotto, int bonusNumber) {
        this(new Lotto(lotto), bonusNumber);
    }

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this(lotto, LottoNumber.from(bonusNumber));
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Rank match(Lotto lotto) {
        return Rank.from(winningLotto.match(lotto), lotto.contains(bonusNumber));
    }
}
