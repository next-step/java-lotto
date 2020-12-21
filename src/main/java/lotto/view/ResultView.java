package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String STATISTICS_TITLE_MESSAGE = "\n당첨 통계\n---------------------";
    private static final String LOTTO_STATISTICS_MESSAGE = "%,d개 일치 (%,d원)- %,d개%n";
    private static final String LOTTO_BONUS_STATISTICS_MESSAGE = "%,d개 일치, 보너스 볼 일치(%,d원)- %,d개%n";
    private static final String EARNINGS_RATIO_MESSAGE = "총 수익률은 %,.2f입니다.\n";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_SIZE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printNumbersOfPurchasedLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(ResultView::printLottoNumbers);
        System.out.println();
    }

    private static void printLottoNumbers(Lotto lotto) {
        String convertedNumbers = lotto.getLottoNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER));
        System.out.println("[" + convertedNumbers + "]");
    }

    public static void printStatisticsForLottos(LottoResult lottoResult) {
        System.out.println(STATISTICS_TITLE_MESSAGE);
        printStatisticsForLotto(lottoResult);
        printEarningsRatio(lottoResult.getEarningsRatio());
    }

    private static void printStatisticsForLotto(LottoResult lottoResult) {
        for (LottoRank lottoRank : LottoRank.winningTypes()) {
            int matchedCount = lottoRank.getMatchedCount();
            int reward = lottoRank.getReward();
            Map<LottoRank, Integer> statistics = lottoResult.getStatistics();
            int count = statistics.get(lottoRank);
            System.out.printf(convertLottoStatisticsMessage(lottoRank.isBonus()), matchedCount, reward, count);
        }
    }

    private static String convertLottoStatisticsMessage(boolean isBonus) {
        if (isBonus) {
            return LOTTO_BONUS_STATISTICS_MESSAGE;
        }
        return LOTTO_STATISTICS_MESSAGE;
    }

    private static void printEarningsRatio(double earningsRatio) {
        System.out.printf(EARNINGS_RATIO_MESSAGE, earningsRatio);
    }

    public static void printPurchasedLottoSize(int manualPurchasedSize, int automatedPurchasedSize) {
        System.out.printf(LOTTO_SIZE_MESSAGE, manualPurchasedSize, automatedPurchasedSize);
    }
}
