package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoException;
import lotto.domain.LottoNumberMatchCount;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResultStatistics;
import lotto.domain.LottoResultStatsCalculator;
import lotto.domain.Money;

public final class ResultView {

    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String DIVIDER_LINE_STYLE = "----------";
    private static final String LOTTO_RESULT_STATS_TITLE_MESSAGE = "당첨 통계";
    private static final String LOTTO_RESULT_STATS_BODY_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String PURCHASED_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT = "[%s]";

    private ResultView() {
    }

    private static void print(final String message) {
        System.out.println(message);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    public static void printException(final LottoException exception) {
        print(exception.getMessage());
    }

    public static void printPurchasedCount(final int purchasedCount) {
        print(String.format(PURCHASED_COUNT_MESSAGE_FORMAT, purchasedCount));
    }

    public static void printPurchaseLottoNumbers(final List<LottoNumbers> lottoNumbers) {
        lottoNumbers.forEach(ResultView::printPurchaseLottoNumbers);
        printEmptyLine();
    }

    public static void printResult(final LottoResultStatsCalculator lottoResultStatsCalculator) {
        printLottoResultStatsTitle();
        printDivider();
        printLottoResultStatsBody(lottoResultStatsCalculator.computeLottoResultStats());
        printProfitRate(lottoResultStatsCalculator.computeProfitRate());
    }

    private static void printPurchaseLottoNumbers(final LottoNumbers purchasedLottoNumbers) {
        print(String.format(PURCHASED_LOTTO_NUMBERS_MESSAGE_FORMAT,
            getPurchaseLottoNumbersMessage(purchasedLottoNumbers)));
    }

    private static String getPurchaseLottoNumbersMessage(final LottoNumbers purchasedLottoNumbers) {
        return purchasedLottoNumbers.getValue().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(COMMA + SPACE));
    }

    private static void printProfitRate(final Double profitRate) {
        print(String.format(PROFIT_RATE_MESSAGE_FORMAT, profitRate));
    }

    private static void printLottoResultStatsTitle() {
        print(LOTTO_RESULT_STATS_TITLE_MESSAGE);
    }

    private static void printDivider() {
        print(DIVIDER_LINE_STYLE);
    }

    private static void printLottoResultStatsBody(final LottoResultStatistics resultStats) {
        print(getFourthRankResultStatsMessage(resultStats));
        print(getThirdRankResultStatsMessage(resultStats));
        print(getSecondRankResultStatsMessage(resultStats));
        print(getFirstRankResultStatsMessage(resultStats));
    }

    private static String getFirstRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getFirstRankLottoNumberMatchCount(),
            resultStats.getFirstRankPrizeMoney(),
            resultStats.getFirstRankCount());
    }

    private static String getSecondRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getSecondRankLottoNumberMatchCount(),
            resultStats.getSecondRankPrizeMoney(),
            resultStats.getSecondRankCount());
    }

    private static String getThirdRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getThirdRankLottoNumberMatchCount(),
            resultStats.getThirdRankPrizeMoney(),
            resultStats.getThirdRankCount());
    }

    private static String getFourthRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getFourthRankLottoNumberMatchCount(),
            resultStats.getFourthRankPrizeMoney(),
            resultStats.getFourthRankCount());
    }

    private static String getRankResultStatsMessage(
        final LottoNumberMatchCount lottoNumberMatchCount,
        final Money prizeMoney,
        final int rankCount
    ) {
        return String.format(LOTTO_RESULT_STATS_BODY_MESSAGE_FORMAT,
            lottoNumberMatchCount.intValue(),
            prizeMoney.intValue(),
            rankCount);
    }

}
