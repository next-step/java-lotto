package lotto.view;

public enum Message {
    LOTTO_MONEY("구입금액을 입력해 주세요."),
    NUMBER_OF_MANUAL_LOTTO_TICKET("수동으로 구매할 로또 수를 입력해 주세요."),
    MANUAL_LOTTO_NUMBER("수동으로 구매할 번호를 입력해 주세요."),
    WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    BONUS_BALL("보너스 볼을 입력해 주세요."),
    NOT_INTEGER("숫자가 아닙니다."),
    PURCHASE_NUMBER("개를 구입했습니다."),
    PURCHASE_LOTTOS("수동으로 %d장, 자동으로 %d개를 구매했습니다."),
    STATISTIC_HEADER("당첨 통계\n---------"),
    WINNER_COUNT("%d개 일치 (%d원)- %d개"),
    FIVE_BONUS_COUNT("%d개 일치, 보너스 볼 일치(%d원)- %d개"),
    STATISTIC_REVENUE("총 수익률은 %.2f입니다.");

    public final String message;

    Message(String message){
        this.message = message;
    }
}
