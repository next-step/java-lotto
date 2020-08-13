package com.hskim.lotto.exception;

import com.hskim.lotto.model.LottoTicketNumber;

public enum LottoExceptionMessage {

    DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다.!"),
    INVALID_NUMBER_SIZE("로또 번호는 " + LottoTicketNumber.LOTTO_NUMBERS_SIZE + "개 여야 합니다.");

    LottoExceptionMessage(String message) {

        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
