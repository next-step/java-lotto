package com.fineroot.lotto.util;

public enum ExceptionMessage {
    MONEY_NEGATIVE("돈은 음수를 가질 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("허용 범위를 벗어난 값입니다.(1 ~ 45)"),
    UTILITY_CLASS("유틸리티 클래스는 생성 불가능합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨 번호와 중복이 될 수 없습니다."),
    MANUAL_LOTTERY_COUNT_OUT_OF_BOUND("허용범위 이상의 번호는 입력할 수 없습니다. (0~ 총 구매 장 수)"),
    LOTTERY_COUNT_NEGATIVE_INPUT("음수 허용되지 않습니다.");

    final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
