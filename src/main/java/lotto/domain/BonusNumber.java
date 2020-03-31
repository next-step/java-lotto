package lotto.domain;

import java.util.Objects;

import static lotto.domain.Constant.LOTTO_NUM_MAX;
import static lotto.domain.Constant.LOTTO_NUM_MIN;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(LottoNumbers lottoNumbers, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateBonusNumber(bonusNumber);
        if (checkDuplication(lottoNumbers)) {
            throw new BonusNumberDuplicateException();
        }
    }

    public boolean isMatch(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUM_MIN || LOTTO_NUM_MAX < bonusNumber) {
            throw new BonusNumberRangeException();
        }
    }

    private boolean checkDuplication(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
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
