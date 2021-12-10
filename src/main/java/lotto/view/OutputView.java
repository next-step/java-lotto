package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoResultType;
import lotto.domain.Lottos;

import java.util.Map;

public class OutputView {
    private static final String LOTTO_SIZE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String STATISTICS_TITLE_MESSAGE = "\n당첨 통계\n---------------------";
    private static final String LOTTO_STATISTICS_MESSAGE = "%,d개 일치 (%,d원)- %,d개%n";
    private static final String EARNINGS_RATIO_MESSAGE = "총 수익률은 %,.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printPurchasedLottoInformation(Lottos lottos) {
        printPurchasedLottoSize(lottos);
        printNumbersForLottos(lottos);
    }

    public static void printStatisticsForLottos(LottoResult lottoResult) {
        System.out.println(STATISTICS_TITLE_MESSAGE);
        printStatisticsForLotto(lottoResult);
        printEarningsRatio(lottoResult.getEarningsRatio());
    }

    private static void printPurchasedLottoSize(Lottos lottos) {
        System.out.printf(LOTTO_SIZE_MESSAGE, lottos.size());
    }

    private static void printNumbersForLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    private static void printStatisticsForLotto(LottoResult lottoResult) {
        for (LottoResultType lottoResultType : LottoResultType.WINNING_TYPES) {
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
