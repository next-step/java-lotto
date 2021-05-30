package lotto.enums;

public enum Message {

    PURCHASE("구입 금액을 입력해주세요. (1,000 ~ 1,000,000)"),
    TICKET_AMOUNT("로또 %d장을 구입합니다."),
    MANUAL_AMOUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    MANUAL_TICKETING("수동으로 로또 번호를 입력해 주세요."),
    SKIP_MANUAL_TICKETING("로또 번호 수동 선택을 생략합니다."),
    AUTOMATIC_TICKETING("수동으로 %d장, 자동으로 %d장 구매했습니다."),
    WINNING_TICKET("지난 주 당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 볼을 입력해 주세요."),

    RESULT_HEAD("당첨 통계\n--------"),
    RESULT_3("3개 일치 (5,000원) - %d개"),
    RESULT_4("4개 일치 (50,000원) - %d개"),
    RESULT_5("5개 일치 (1,500,000원) - %d개"),
    RESULT_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RESULT_6("6개 일치 (2,000,000,000원) - %d개"),
    RESULT_TOTAL("당첨금은 %d 원 입니다."),
    RESULT_TAIL("총 수익률은 %s 입니다. (1 기준)");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
