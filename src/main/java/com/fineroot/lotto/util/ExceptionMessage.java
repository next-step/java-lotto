package com.fineroot.lotto.util;

public enum ExceptionMessage {
    MONEY_NEGATIVE("돈은 음수를 가질 수 없습니다.");

    final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
