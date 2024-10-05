package step2.enums;

public enum ResultMessage {

    RESULT_LOTTO_COUNT("{count}개를 구매했습니다."),
    RESULT_LOTTO_STATICS("당첨통계"),
    RESULT_RATE_RETURN("총 수익률은 {rate}입니다.");

    ResultMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String message() {
        return message;
    }

}
