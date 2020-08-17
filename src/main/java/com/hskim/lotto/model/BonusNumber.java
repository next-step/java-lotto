package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;

import java.util.List;

public class BonusNumber extends LottoNumber {

    public BonusNumber(int bonusNumber, List<LottoNumber> winningNumberList) {
        super(bonusNumber);
        validateBonusNumber(bonusNumber, winningNumberList);
    }

    private void validateBonusNumber(int bonusNumber, List<LottoNumber> winningNumberList) {
        if (winningNumberList.contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException(LottoExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
