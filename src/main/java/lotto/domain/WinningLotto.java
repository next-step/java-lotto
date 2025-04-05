package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        checkValid(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkValid(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isMatch(bonusNumber)) {
            throw new IllegalArgumentException("bonusNo is matched with lotto");
        }
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.valueOf(this.lotto.matchCount(lotto), lotto.isMatch(bonusNumber));
    }
}
