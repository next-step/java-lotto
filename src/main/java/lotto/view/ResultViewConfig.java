package lotto.view;

public class ResultViewConfig {

    public static final String OUTPUT_BUY_LOTTO_COUNT = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    public static final String WINNING_STATISTICS = "당첨 통계\n---------\n";
    public static final String WINNING_STATISTICS_GRID = "%s개 일치%s (%s원)- %s개\n";
    public static final String WINNING_STATISTICS_BONUS_GRID = ", 보너스 볼 일치";
    public static final String WINNING_STATISTICS_RESULT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)\n";
    public static final String DEFICIT = "손해";
    public static final String SURPLUS = "이득";

    private ResultViewConfig(){}
}
