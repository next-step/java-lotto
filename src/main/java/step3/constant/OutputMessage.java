package step3.constant;

public enum OutputMessage {
    NEED_PRICE("구입금액을 입력해 주세요."),
    BUY_TEXT("개를 구매했습니다."),
    NEED_VICTORY_NUMBER("지난 주 당첨 번호를 입력해 주세요.(,구분자로 사용)"),
    STATISTICS("당첨 통계"),
    SEPERATOR("---------"),
    ONE_LOTTO("[%s]"),
    COUNT("%d개 일치(%d원)-%d개"),
    BENEFIT("총 수익률은 %s입니다.");

    private String text;

    private OutputMessage(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
