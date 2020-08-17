package com.hskim.lotto.exception;

import com.hskim.lotto.model.LottoTicket;

public enum LottoExceptionMessage {

    DUPLICATED_NUMBER("로또 번호는 중복될 수 없습니다.!"),
    INVALID_NUMBER_SIZE("로또 번호는 " + LottoTicket.LOTTO_NUMBERS_SIZE + "개 여야 합니다."),
    NON_NUMERICAL_VALUE("입력값이 숫자가 아닙니다."),
    INVALID_PURCHASE_PRICE("구매 가격이 잘못되었습니다. 로또 한장의 가격은 " + LottoTicket.LOTTO_PRICE + "입니다."),
    ILLEGAL_STATE("해당 클래스에서 호출 불가능한 메소드 입니다.");

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
