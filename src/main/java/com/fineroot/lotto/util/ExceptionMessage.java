package com.fineroot.lotto.util;

public enum ExceptionMessage {
    MONEY_NEGATIVE("돈은 음수를 가질 수 없습니다."),

    LOTTO_NUMBER_OUT_OF_RANGE("허용 범위를 벗어난 값입니다.(1 ~ 45)");

    final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
