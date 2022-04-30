package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class OutputView {
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String SEPARATOR = "---------";
    private static final int START_MATCH_COUNT = 3;
    private static final int END_MATCH_COUNT = 6;

    public static void outputLottoNumbers(Lottos lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.length());
        lottos.print();
        System.out.println();
    }

    public static void outputWinningStatistics(Lottos lottos, String previousWeekWinningNumber) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATOR);

        List<Integer> matchNumberCounts = lottos.getMatchNumberCounts(new LottoNumbers(previousWeekWinningNumber));
        IntStream.rangeClosed(START_MATCH_COUNT, END_MATCH_COUNT)
                .forEach(outputMatchStatistics(matchNumberCounts));
    }

    private static IntConsumer outputMatchStatistics(List<Integer> matchLottos) {
        return matchLotto -> System.out.printf("%s개 일치 (%s원)- %s\n",
                matchLotto,
                MatchCount.getWinningAmountWith(matchLotto),
                getCount(matchLottos, matchLotto));
    }

    private static int getCount(List<Integer> matchLottos, int matchLotto) {
        return (int) matchLottos.stream()
                .filter(it -> it == matchLotto)
                .count();
    }

    public static void outputRevenueRate(Lottos lottos, String previousWeekWinningNumber) {
        double revenueRate = lottos.getRevenueRate(new LottoNumbers(previousWeekWinningNumber));
        System.out.printf("총 수익률은 %s입니다.", revenueRate);
    }
}

