package calculator.context;

public enum Message {
    INPUT_MSG("구입금액을 입력해 주세요."),
    RESULT_HEAD_MSG("당첨 통계");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
