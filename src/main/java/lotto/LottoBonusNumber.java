package lotto;

import lotto.exception.BonusNumberException;

import java.util.Objects;

public class LottoBonusNumber {
    private final int bonusNumber;

    public LottoBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoBonusNumber(Lotto winLotto, int bonusNumber) {
        if(winLotto.isMatchNumber(bonusNumber)){
            throw new BonusNumberException();
        }
        LottoValidationUtils.checkNumberAndRange(String.valueOf(bonusNumber));
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBonusNumber that = (LottoBonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
