package lotto.domain;

import lotto.utils.ConvertUtil;

import java.util.Objects;

public class BonusBall {
    private final LottoNumber bonusNumber;

    public BonusBall(String bonusNumber) {
        this(ConvertUtil.toInt(bonusNumber));
    }

    public BonusBall(int bonusNumber) {
        this(new LottoNumber(bonusNumber));
    }

    public BonusBall(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean isSame(int bonusNumber) {
        return isSame(new BonusBall(bonusNumber));
    }

    public boolean isSame(BonusBall bonusNumber) {
        return this.bonusNumber.equals(bonusNumber.bonusNumber);
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
