package lotto.model;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(Lotto lotto, LottoNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public Rank getRank(Lotto userLotto) {
        return Rank.valueOf(userLotto.getMatchCount(lotto), userLotto.isContain(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
