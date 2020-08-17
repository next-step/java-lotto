package kr.heesu.lotto.enums;

public enum Message {
    INPUT_FOR_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_FOR_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요"),
    OUTPUT_FORMAT_FOR_PURCHASE_SIZE("%d개를 구매했습니다."),
    OUTPUT_FORMAT_FOR_MATCH_RESULT("%d개 일치 (%d원)- %d개"),
    OUTPUT_FORMAT_FOR_PROFIT_RATE("총 수익률은 %.2f 입니다."),
    OUTPUT_FOR_PROFIT_RATE_LOSS(" (기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
    OUTPUT_FOR_PROFIT_RATE_BENEFIT(" (기준이 1이기 때문에 결과적으로 이득이라는 의미임)"),
    EXCEPTION_FOR_PURCHASE_AMOUNT("구매 금액이 잘못 되었습니다."),
    EXCEPTION_FOR_WINNING_NUMBERS("당첨 번호가 잘못 되었습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String of() {
        return this.message;
    }
}
