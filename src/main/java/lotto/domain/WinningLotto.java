package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String lotto, int bonusNumber) {
        this(new Lotto(lotto), bonusNumber);
    }

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this(lotto, new LottoNumber(bonusNumber));
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int match(Lotto lotto) {
        return this.lotto.match(lotto);
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
