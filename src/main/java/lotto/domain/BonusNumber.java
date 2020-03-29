package lotto.domain;

import java.util.Objects;

import static lotto.domain.Constant.LOTTO_NUM_MAX;
import static lotto.domain.Constant.LOTTO_NUM_MIN;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(LottoTicket lottoTicket, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateBonusNumber(bonusNumber);
        if (checkDuplication(lottoTicket)) {
            throw new BonusNumberDuplicateException();
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUM_MIN || LOTTO_NUM_MAX < bonusNumber) {
            throw new BonusNumberRangeException();
        }
    }

    private boolean checkDuplication(LottoTicket lottoTicket) {
        return lottoTicket.has(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonusNumber)) return false;
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
