package lotto.domain;

import java.util.Objects;

public class BonusBall {
    private LottoNumber bonusNumber;

    public BonusBall(final String input) {
        this.bonusNumber = LottoNumberGenerator.cache[Integer.valueOf(input) - LottoNumber.MIN];
    }

    LottoNumber getLottoNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BonusBall bonusBall = (BonusBall) o;
        return Objects.equals(bonusNumber, bonusBall.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
