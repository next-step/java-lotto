package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.stream.Collectors;

public class OutputView {
    private static final String LOTTO_SIZE_MESSAGE = "%n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String STATISTICS_TITLE_MESSAGE = "\n당첨 통계\n---------------------";
    private static final String LOTTO_STATISTICS_MESSAGE = "%,d개 일치 (%,d원)- %,d개%n";
    private static final String LOTTO_BONUS_STATISTICS_MESSAGE = "%,d개 일치, 보너스 볼 일치(%,d원)- %,d개%n";
    private static final String EARNINGS_RATIO_PROFIT_MESSAGE = "총 수익률은 %,.2f입니다.\n";
    private static final String EARNINGS_RATIO_LOSS_MESSAGE = "총 수익률은 %,.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";
    private static final int BASE_EARNINGS_POINT = 1;

    private OutputView() {
        throw new AssertionError();
    }

    public static void printPurchasedLottoInformation(Lottos lottos, int manualPurchasingSize) {
        printPurchasedLottoSize(automatedPurchasingSize(lottos, manualPurchasingSize), manualPurchasingSize);
        printNumbersForLottos(lottos);
    }

    public static void printStatisticsForLottos(LottoResult lottoResult) {
        System.out.println(STATISTICS_TITLE_MESSAGE);
        printStatisticsForLotto(lottoResult);
        printEarningsRatio(lottoResult.earningsRatio());
    }

    private static int automatedPurchasingSize(Lottos lottos, int manualPurchasingSize) {
        return lottos.size() - manualPurchasingSize;
    }

    private static void printPurchasedLottoSize(int automatedPurchasingSize, int manualPurchasingSize) {
        System.out.printf(LOTTO_SIZE_MESSAGE, manualPurchasingSize, automatedPurchasingSize);
    }

    private static void printNumbersForLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(formattedLottoNmbers(lotto)));
        System.out.println();
    }

    private static String formattedLottoNmbers(Lotto lotto) {
        return String.format("[%s]", lotto.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static void printStatisticsForLotto(LottoResult lottoResult) {
        lottoResult.ascendingWinningTypes()
                .forEach(v -> System.out.print(statisticMessage(lottoResult, v)));
    }

    private static String statisticMessage(LottoResult lottoResult, LottoRank lottoRank) {
        if (lottoRank.hasNotBonus()) {
            return String.format(LOTTO_STATISTICS_MESSAGE, lottoRank.matchedCount(), lottoRank.reward(), lottoResult.countByType(lottoRank));
        }
        return String.format(LOTTO_BONUS_STATISTICS_MESSAGE, lottoRank.matchedCount(), lottoRank.reward(), lottoResult.countByType(lottoRank));
    }

    private static void printEarningsRatio(double earningsRatio) {
        System.out.print(earningsRatioMessage(earningsRatio));
    }

    private static String earningsRatioMessage(double earningsRatio) {
        if (earningsRatio < BASE_EARNINGS_POINT) {
            return String.format(EARNINGS_RATIO_LOSS_MESSAGE, earningsRatio);
        }
        return String.format(EARNINGS_RATIO_PROFIT_MESSAGE, earningsRatio);
    }
}
