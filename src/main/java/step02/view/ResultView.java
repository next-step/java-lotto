package step02.view;

import java.util.List;

public class ResultView {
    private static final String LOTTO_BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String HORIZON = "---------";
    private static final String WINNING_STATISTICS_MESSAGE = "%d 개 일치 (%d원)- %d개";
    private static final String YIELD_MESSAGE = "총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String LOSS = "손해";
    private static final String GAIN = "이득";


    public static void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_BUY_COUNT_MESSAGE);
    }

    public static void showLottos(List<Lotto> lottos) {
        lottos.forEach((lotto) -> System.out.println(lotto.toString()));
    }

    //    - 당첨 통계를 보여주는 기능
    public static void showWinningStatistics(List<WinningStatistic> WinningStatistics) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(HORIZON);

        WinningStatistics.forEach(statistic ->
            System.out.printf(
                    WINNING_STATISTICS_MESSAGE,
                    statistic.getTarget(),
                    statistic.getReward(),
                    statistic.getMatchCount()
            )
        );

    }

    public static void showYield(float yield) {
        String result = yield < 1 ? LOSS : GAIN;
        System.out.printf(YIELD_MESSAGE, yield, result);
    }

}
