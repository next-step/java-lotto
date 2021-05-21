package step3.constant;

public enum OutputMessage {
    NEED_PRICE("구입금액을 입력해 주세요."),
    BUY_TEXT("개를 구매했습니다.");

    private String text;

    private OutputMessage(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
