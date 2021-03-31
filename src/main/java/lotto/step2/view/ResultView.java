package lotto.step2.view;

import lotto.step2.domain.Lottos;
import lotto.step2.domain.WinningStatistics;

public class ResultView {

    private final static String MESSAGE_WINNING_RESULT = String.format("%s%s%s", "당첨 통계", System.lineSeparator(), "---------");
    private final static String MESSAGE_TOTAL_PROFITS = "총 수익률은 ";
    private final static String MESSAGE_IS = "입니다.";


    private ResultView() {
    }

    public static void printLottos(Lottos lottos, long lottoCount) {
        System.out.println();
        System.out.println(String.format("수동으로 %s장, 자동으로 %s개를 구매했습니다.", lottoCount, lottos.size() - lottoCount));
        lottos.lottos()
                .stream()
                .forEach(lotto -> System.out.println(lotto.lottoNumbers()));
        System.out.println();
    }

    public static void printResult(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println(MESSAGE_WINNING_RESULT);
        winningStatistics.statistics()
                .keySet()
                .stream()
                .filter(rank -> rank.hit() > 0)
                .sorted()
                .forEach(rank -> System.out.println(String.format("%s (%s원)- %s개", rank.message(), rank.amount(), winningStatistics.statistics().get(rank))));
        System.out.println(String.format("총 수익률은 %s입니다.", winningStatistics.profits()));
    }

}

