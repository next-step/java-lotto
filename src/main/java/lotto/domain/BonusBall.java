package lotto.domain;

import java.util.Objects;

public class BonusBall {
    private final LottoNumber bonusNumber;

    public BonusBall(int bonusNumber) {
        this(new LottoNumber(bonusNumber));
    }

    public BonusBall(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall = (BonusBall) o;
        return Objects.equals(bonusNumber, bonusBall.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
