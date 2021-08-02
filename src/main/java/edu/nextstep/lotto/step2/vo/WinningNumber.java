package edu.nextstep.lotto.step2.vo;

import edu.nextstep.lotto.common.BusinessException;
import edu.nextstep.lotto.step2.error.LottoError;

public class WinningNumber {

    private final int number;

    public WinningNumber(String number) {
        this.number = convertStringToNumber(number);
    }

    private int convertStringToNumber(String text) {
        int number;

        try {
            number = Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new BusinessException(LottoError.INVALID_VALUE_NOT_NUMBER_FORMAT);
        }

        return number;
    }

    public int getNumber() {
        return number;
    }
}
