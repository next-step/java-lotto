package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;

import java.util.List;
import java.util.Objects;

public class BonusNumber {

    private LottoNumber bonusNumber;

    public BonusNumber(int bonusNumber, List<LottoNumber> winningNumberList) {
        this.bonusNumber = new LottoNumber(bonusNumber);
        validateBonusNumber(bonusNumber, winningNumberList);
    }

    private void validateBonusNumber(int bonusNumber, List<LottoNumber> winningNumberList) {
        if (winningNumberList.contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException(LottoExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonusNumber)) return false;
        BonusNumber that = (BonusNumber) o;
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
