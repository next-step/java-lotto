package lottos.view;

import lottos.domain.Lotto;
import lottos.domain.Result;
import lottos.domain.Statistics;
import lottos.domain.WinningPrize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LottoConsoleView {

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getElements());
        }
        System.out.println();
    }

    public void printStatistics(Statistics statistics) {
        printIntroStatistics();
        printNumberOfMatches(statistics);
        printYield(statistics);
    }

    private double calculateYield(Statistics statistics) {
        double prizeAmountTotal = calculatePrizeAmountTotal(statistics);
        return prizeAmountTotal / statistics.getPurchaseAmount();
    }

    private Integer calculatePrizeAmountTotal(Statistics statistics) {
        return statistics.getLottoResults()
                .stream()
                .map(Result::getWinningPrize)
                .map(WinningPrize::getPrizeAmount)
                .reduce(0, Integer::sum);
    }

    private void printIntroStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
    }

    private void printNumberOfMatches(Statistics statistics) {
        Map<WinningPrize, List<WinningPrize>> countMap = groupingByCount(statistics);

        for (WinningPrize winningPrize : WinningPrize.values()) {

            final int prize = winningPrize.getPrizeAmount();
            final int count = winningPrize.getNumberOfMatches();
            final List<WinningPrize> lottoMatchers = countMap.getOrDefault(winningPrize, new ArrayList<>());

            if (winningPrize.isWinning()) {
                System.out.printf("%d개 일치 (%d원) - %d개%n", count, prize, lottoMatchers.size());
            }
        }
    }

    private Map<WinningPrize, List<WinningPrize>> groupingByCount(Statistics statistics) {
        return statistics.getLottoResults()
                .stream()
                .map(Result::getWinningPrize)
                .collect(Collectors.groupingBy(winningPrize -> winningPrize));
    }

    private void printYield(Statistics statistics) {
        double yield = calculateYield(statistics);
        System.out.printf("수익률은 %.2f입니다.", yield);
    }
}
