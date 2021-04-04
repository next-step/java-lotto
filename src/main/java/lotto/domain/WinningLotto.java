package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final Number bonusNumber;

    private WinningLotto(final Lotto lotto, final Number bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final Lotto lotto, final Number bonusNumber) {
        lotto.validateBonusNumber(bonusNumber);
        return new WinningLotto(lotto, bonusNumber);
    }

    public Rank rank(Lotto lotto) {
        int matchCount = lotto.matchCount(this.lotto);
        boolean matchBonus = lotto.matchBonus(this.bonusNumber);
        return Rank.valueOf(matchCount, matchBonus);
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
