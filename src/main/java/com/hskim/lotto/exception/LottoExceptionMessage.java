package com.hskim.lotto.exception;

import com.hskim.lotto.model.LottoNumber;
import com.hskim.lotto.model.LottoTicket;

public enum LottoExceptionMessage {
    DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다.!"),
    INVALID_NUMBER_SIZE("로또 번호는 " + LottoTicket.LOTTO_NUMBERS_SIZE + "개 여야 합니다."),
    INVALID_PURCHASE_PRICE("구매 가격이 잘못되었습니다. 로또 한장의 가격은 " + LottoTicket.LOTTO_PRICE + "입니다."),
    LESS_THEN_LOW_BOUND("로또 번호가 잘못 되었습니다. 로또 번호의 최소 값은 " + LottoNumber.LOW_BOUND + "입니다."),
    EXCEED_UPPER_BOUND("로또 번호가 잘못 되었습니다. 로또 번호의 최대 값은" + LottoNumber.UPPER_BOUND + "입니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복됩니다!.");

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
