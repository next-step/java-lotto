package lotto.domain.model.lotto;

import java.util.Objects;
import java.util.Set;

public class BonusNumber extends LottoNumber{

    public BonusNumber(final int number) {
        super(number);
    }

    public void validateNotInWinningNumbers(final Set<LottoNumber> winningNumbers) {
        if (winningNumbers.contains(this)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return Objects.equals(super.getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(super.getNumber());
    }
} 
