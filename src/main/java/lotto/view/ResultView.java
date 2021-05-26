package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottoes;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "%n당첨통계%n---------%n";
    private static final String REVENUE_RATE_MESSAGE = "총 수익률은 %s입니다.%s";
    private static final String DAMAGE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String GAIN_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final int MEANING_STANDARD_VALUE = 1;

    private ResultView() {}

    public static void printPurchaseCountAndLottoes(final LottoGame lottoGame, final int countOfManualLotto) {
        int countOfAutoLotto = lottoGame.getLottoCount() - countOfManualLotto;
        System.out.print(System.lineSeparator());
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, countOfManualLotto, countOfAutoLotto));
        printLottoes(lottoGame.getLottoes());
    }

    private static void printLottoes(final Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(prettyString(lotto));
        }
    }

    private static String prettyString(final Lotto lotto) {
        return String.format("%s%s%s", "[",
                lotto.getLotto()
                        .stream()
                        .map(LottoNumber::getNumber)
                        .sorted()
                        .map(i -> String.valueOf(i))
                        .collect(Collectors.joining(", ")),
                "]");
    }

    public static void printStatistics(final LottoStatistics lottoStatistics) {
        System.out.printf(WINNING_STATISTICS_MESSAGE);
        printWinningResults(lottoStatistics.getWinningResults());
        printRevenueRate(lottoStatistics.getRevenueRate());
    }

    private static void printWinningResults(final Map<Rank, Integer> winningResults) {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.MISS))
                .forEach(rank -> System.out.println(String.format(rank.getMessage(), winningResults.get(rank))));
    }

    private static void printRevenueRate(final BigDecimal revenueRate) {
        System.out.println(String.format(REVENUE_RATE_MESSAGE, revenueRate, getMeaningMessage(revenueRate)));
    }

    private static String getMeaningMessage(final BigDecimal revenueRate) {
        return revenueRate.intValue() < MEANING_STANDARD_VALUE ? DAMAGE_MESSAGE : GAIN_MESSAGE;
    }
}
