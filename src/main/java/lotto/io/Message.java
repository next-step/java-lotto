package lotto.io;

public enum Message {

    REQUEST_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    REQUEST_WINNING_NUMBER("지난주 당첨 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계 \n ---------");

    public final String message;

    Message(String message) {
        this.message = message;
    }

}