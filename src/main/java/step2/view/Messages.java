package step2.view;

public class Messages {
    public static final String REQUEST_PRICE = "구입금액을 입력해 주세요.";
    public static final String RESPONSE_PRICE_TEMPLATE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    public static final String REQUEST_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String WINNING_STATISTIC_TEMPLATE = "\n당첨 통계\n---------\n"
        + "3개 일치 (%d원)- %d개\n"
        + "4개 일치 (%d원)- %d개\n"
        + "5개 일치 (%d원)- %d개\n"
        + "5개 일치, 보너스 볼 일치(%d원) - %d개\n"
        + "6개 일치 (%d원)- %d개\n"
        + "총 수익률은 %.2f입니다.";
    public static final String WINNING_STATISTIC_RESULT_LOSS_CASE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String REQUEST_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String REQUEST_MANUAL_LOTTOS = "수동으로 구매할 번호를 입력해 주세요.";
}
