package lotto.domain;

import java.util.Objects;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String bonusNumberString) {
        bonusNumber = Integer.parseInt(bonusNumberString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
