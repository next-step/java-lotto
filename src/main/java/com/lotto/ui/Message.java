package com.lotto.ui;

public enum Message {
    REQUIRE_LOTTO_PRICE("구매금액을 입력해 주세요."),
    CONFIRM_BUY_COUNT("개를 구매했습니다."),
    REQUIRE_WINNING_NUMBERS("지난 주 담청 번호를 입력해 주세요."),
    WINNING_STATISTICS("담청 통계"),
    WINNING_STATISTICS_DETAIL("%s개 일치%s(%s)- %d개"),
    INVESTMENT("총 수익률은 %.2f 입니다."),
    REQUIRE_BONUS_NUMBER("보너스 볼을 입력해주세요."),
    WINNING_BONUS(", 보너스 볼 일치")
    ;

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
