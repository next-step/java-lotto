package step2.enums;

public enum Message {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_PRIZE_NUM("지난 주 당첨 번호를 입력해 주세요."),
    RESULT_LOTTO_COUNT("{count}개를 구매했습니다."),
    RESULT_LOTTO_STATICS("당첨통계"),
    RESULT_THREE_CORRECT("3개 일치 (5000원)- {count}개"),
    RESULT_FOUR_CORRECT("4개 일치 (50000원)- {count}개"),
    RESULT_FIVE_CORRECT("5개 일치 (1500000원)- {count}개"),
    RESULT_SIX_CORRECT("6개 일치 (2000000000원)- {count}개"),
    RESULT_RATE_RETURN("총 수익률은 {rate}입니다.");

    Message(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }
}
