package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(final Lotto lotto, final LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final Lotto lotto, final LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        return new WinningLotto(lotto, bonusNumber);
    }

    private static void validateBonusNumber(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.getLotto().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함되지 않아야 합니다.");
        }
    }

    public Rank getRank(final Lotto lotto) {
        return Rank.valueOf(lotto.getMatchCount(this.lotto), lotto.matchBonus(this.bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
