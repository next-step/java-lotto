package step3.constant;

public enum OutputMessage {
    NEED_PRICE("구입금액을 입력해 주세요."),
    BUY_TEXT("개를 구매했습니다."),
    NEED_VICTORY_NUMBER("지난 주 당첨 번호를 입력해 주세요.(,구분자로 사용)"),
    STATISTICS("당첨 통계"),
    SEPERATOR("---------"),
    BRACKETS_START("["),
    BRACKETS_END("]"),
    THREE_WINNER("3개 일치({0}원)-{1}개"),
    FOUR_WINNER("4개 일치({0}원)-{1}개"),
    FIVE_WINNER("5개 일치({0}원)-{1}개"),
    SIX_WINNER("6개 일치({0}원)-{1}개"),
    BENEFIT("총 수익률은 {0}입니다.");

    private String text;

    private OutputMessage(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
