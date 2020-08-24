package com.hskim.lotto.exception;

import com.hskim.lotto.model.LottoTicket;

public enum LottoTicketingExceptionMessage {
    INVALID_PURCHASE_PRICE("구매 가격이 잘못되었습니다. 로또 한장의 가격은 " + LottoTicket.LOTTO_PRICE + "입니다."),
    NEGATIVE_TICKETING_NUMBER("티켓 발급 수는 0이상 이여야 합니다."),
    EXCEED_PURCHASE_PRICE("구입금액을 초과하여 구매하셨습니다.");

    LottoTicketingExceptionMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
