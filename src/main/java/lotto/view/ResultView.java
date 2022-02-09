package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;

public class ResultView {

    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT = "당첨 통계";
    private static final String DIVISION = "================";
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final String TOTAL_INCOME_PRE = "총 수익률은 ";
    private static final String TOTAL_INCOME_POST = "입니다.";

    private ResultView() {

    }

    public static void printCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public static void printWin(WinningLotto winning) {
        System.out.println(LOTTO_RESULT);
        System.out.println(DIVISION);

        for (Statistics statistics : Statistics.values()) {
            printResult(statistics, winning);
        }
    }

    private static void printResult(Statistics statistics, WinningLotto winning) {
        String bonusBall = "";

        if (statistics.isSecond()) {
            bonusBall = BONUS_BALL_MATCH;
        }

        System.out.printf("%d개 일치" + bonusBall + "(%d원)- %d개\n", statistics.getMatch(),
            statistics.getMoney(), winning.winResult().getOrDefault(statistics, 0));
    }

    public static void printProfit(int money) {
        System.out.printf(TOTAL_INCOME_PRE + "%.2f" + TOTAL_INCOME_POST + "\n", (float) WinningLotto.getWinProfit() / money);
    }
}
