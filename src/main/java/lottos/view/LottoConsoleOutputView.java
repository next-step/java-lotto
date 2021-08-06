package lottos.view;

import lottos.domain.Lotto;
import lottos.domain.Lottos;
import lottos.domain.Prize;
import lottos.domain.Statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LottoConsoleOutputView {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.elements()) {
            System.out.println(lotto.elements());
        }
        System.out.println();
    }

    public void printStatistics(Statistics statistics) {
        printIntroStatistics();
        printNumberOfMatches(statistics);
        printYield(statistics);
    }

    private void printIntroStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
    }

    private void printNumberOfMatches(Statistics statistics) {
        Map<Prize, List<Prize>> prizeMap = statistics.groupingByPrize();

        List<Prize> winningPrizes = Arrays.stream(Prize.values())
                .filter(Prize::isWinning)
                .collect(Collectors.toList());

        for (Prize winningPrize : winningPrizes) {

            final int prize = winningPrize.getPrizeAmount();
            final int count = winningPrize.getNumberOfMatches();
            final List<Prize> lottoMatchers = prizeMap.getOrDefault(winningPrize, new ArrayList<>());

            System.out.printf("%d개 일치 (%d원) - %d개%n", count, prize, lottoMatchers.size());
        }
    }

    private void printYield(Statistics statistics) {
        Double yield = statistics.calculateYield();
        System.out.printf("수익률은 %.2f입니다.", yield);
    }
}
