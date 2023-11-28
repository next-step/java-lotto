package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class Bonus {
    protected static final String BONUS_NUMBER_OVERLAPPING_EXCEPTION = "보너스 숫자와 당첨 로또의 숫자가 겹칩니다.";

    private final LottoNumber bonusNumber;

    public Bonus(int bonusNumber, Lotto lotto) {
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
        validateOverlapping(bonusLottoNumber, lotto);
        this.bonusNumber = bonusLottoNumber;
    }

    private void validateOverlapping(LottoNumber bonusLottoNumber, Lotto lotto) {
        if (isOverlapping(bonusLottoNumber, lotto)) {
            throw new IllegalArgumentException(BONUS_NUMBER_OVERLAPPING_EXCEPTION);
        }
    }

    private boolean isOverlapping(LottoNumber bonusLottoNumber, Lotto lotto) {
        return lotto.isOverlapping(bonusLottoNumber);
    }

    public boolean isSame(LottoNumber lottoNumber) {
        return this.bonusNumber == lottoNumber;
    }

    public boolean containsBonus(Set<LottoNumber> lotto) {
        return lotto.contains(this.bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bonus bonus = (Bonus) o;
        return Objects.equals(bonusNumber, bonus.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "bonusNumber=" + bonusNumber +
                '}';
    }
}
