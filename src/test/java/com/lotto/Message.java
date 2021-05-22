package com.lotto;

public enum Message {
    REQUIRE_LOTTO_PRICE("구매금액을 입력해 주세요."),
    CONFIRM_BUY_COUNT("개를 구매했습니다."),
    REQUIRE_WINNING_NUMBERS("지난 주 담청 번호를 입력해 주세요."),
    WINNING_STATISTICS("담청 통계"),
    WINNING_STATISTICS_DETAIL("%s개 일치 (%s)- %d개"),
    INVESTMENT("총 수익률은 %.2f 입니다."),
    PRICE_FORMAT_EXCEPTION("가격이 올바르지 않습니다."),
    WRONG_INPUT("입력값이 올바르지 않습니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
