package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.enums.LottoPrize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ResultView {
    private static final String PURCHASE_RESULT_FORMAT = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS_INTRO = "당첨 통계\n---------";
    private static final String WINNING_STATISTICS_FORMAT = "%s개 일치 (%s원)- %s개";
    private static final String WINNING_STATISTICS_TOTAL_PROFIT_RATE_FORMAT = "총 수익률은 %s (배)입니다.";

    public static void printPurchase(Lottos lottos) {
        System.out.println(String.format(PURCHASE_RESULT_FORMAT, lottos.count()));
        lottos.forEach(lotto -> System.out.println(lotto.numbers()));
    }

    public static void printWinningStatistics(Lottos lottos, Lotto winningLotto) {
        System.out.println(WINNING_STATISTICS_INTRO);

        List<LottoPrize> lottoPrizes = Arrays.stream(LottoPrize.values()).collect(toList());
        Collections.reverse(lottoPrizes);
        lottoPrizes.forEach(lottoPrize -> System.out.println(String.format(WINNING_STATISTICS_FORMAT,
                lottoPrize.matchedCount(),
                lottoPrize.money(),
                lottos.winningCount(winningLotto, lottoPrize))));

        System.out.println(String.format(WINNING_STATISTICS_TOTAL_PROFIT_RATE_FORMAT,
                lottos.totalProfitRate(winningLotto)));
    }
}
