package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoResultType;
import lotto.domain.Lottos;

import java.util.Map;

public class ResultView {
    private static final String STATISTICS_TITLE_MESSAGE = "\n당첨 통계\n---------------------";
    public static final String LOTTO_STATISTICS_MESSAGE = "%,d개 일치 (%,d원)- %,d개%n";
    private static final String EARNINGS_RATIO_MESSAGE = "총 수익률은 %,.2f입니다.\n";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printNumbersForLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public static void printStatisticsForLottos(LottoResult lottoResult) {
        System.out.println(STATISTICS_TITLE_MESSAGE);
        printStatisticsForLotto(lottoResult);
        printEarningsRatio(lottoResult.getEarningsRatio());
    }

    private static void printStatisticsForLotto(LottoResult lottoResult) {
        for (LottoResultType lottoResultType : LottoResultType.winningTypes()) {
            int matchedCount = lottoResultType.getMatchedCount();
            int reward = lottoResultType.getReward();
            Map<LottoResultType, Integer> statistics = lottoResult.getStatistics();
            int count = statistics.get(lottoResultType);
            System.out.printf(LOTTO_STATISTICS_MESSAGE, matchedCount, reward, count);
        }
    }

    private static void printEarningsRatio(double earningsRatio) {
        System.out.printf(EARNINGS_RATIO_MESSAGE, earningsRatio);
    }
}
