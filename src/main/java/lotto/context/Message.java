package lotto.context;

public enum Message {
    INPUT_MSG("구입금액을 입력해 주세요."),
    BUY_COUNT("%1개를 구매했습니다."),
    INPUT_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    RESULT_HEAD("당첨 통계"),
    RESULT_DELIMITER("---------"),
    RESULT_BODY("%1개 일치 (%2원)- %3개"),
    RESULT_EARNING_RATE("총 수익률은 %1입니다.");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
