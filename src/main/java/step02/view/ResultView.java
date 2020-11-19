package step02.view;

import utils.DoubleParser;
import step02.domain.Lotto;
import step02.domain.LottoReward;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String HORIZON = "---------";
    private static final String WINNING_STATISTICS_MESSAGE = "%d 개 일치 (%d원)- %d개";
    private static final String YIELD_MESSAGE = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String LOSS = "손해";
    private static final String GAIN = "이득";


    public static void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_BUY_COUNT_MESSAGE);
    }

    public static void showLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.print()));
    }

    public static void showWinningStatistics(List<LottoReward> winningStatistics) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(HORIZON);

        winningStatistics.forEach(statistic -> {
                    System.out.printf(
                            WINNING_STATISTICS_MESSAGE,
                            statistic.getCount(),
                            statistic.getReward(),
                            statistic.getNumber()
                    );
                    System.out.println();
                }
        );

    }

    public static void showYield(double yield) {
        String result = yield < 1 ? LOSS : GAIN;
        System.out.printf(YIELD_MESSAGE, DoubleParser.getTwoDecimalPoint(yield), result);
    }

}
