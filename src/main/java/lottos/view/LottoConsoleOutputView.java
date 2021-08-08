package lottos.view;

import lottos.domain.Lotto;
import lottos.domain.LottoGameStatistics;
import lottos.domain.LottoPrize;
import lottos.domain.Lottos;
import lottos.domain.numbers.Number;

import java.util.*;
import java.util.stream.Collectors;


public class LottoConsoleOutputView {

    public void printLottos(final Lottos lottos) {
        for (Lotto lotto : lottos.elements()) {

            final List<Integer> numbers = lotto.getNumbers().elements()
                    .stream()
                    .map(Number::value)
                    .collect(Collectors.toList());

            System.out.println(numbers);
        }
        System.out.println();
    }

    public void printPurchaseCount(final Lottos lottos) {
        int purchaseCount = lottos.elements().size();
        System.out.printf("%d개를 구매했습니다.%n", purchaseCount);
    }

    private void printIntroStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
    }

    public void printStatistics(final LottoGameStatistics lottoGameStatistics) {
        printIntroStatistics();
        printCountOfMatches(lottoGameStatistics);
        printYield(lottoGameStatistics);
    }

    private void printCountOfMatches(final LottoGameStatistics lottoGameStatistics) {
        Map<LottoPrize, List<LottoPrize>> prizeMap = lottoGameStatistics.groupingByPrize();

        List<LottoPrize> winningLottoPrizes = Arrays.stream(LottoPrize.values())
                .filter(LottoPrize::isWinning)
                .sorted(Comparator.comparing(LottoPrize::getPrizeAmount))
                .collect(Collectors.toList());

        for (LottoPrize winningLottoPrize : winningLottoPrizes) {
            printCountOfMatches(prizeMap, winningLottoPrize);
        }
    }

    private void printCountOfMatches(Map<LottoPrize, List<LottoPrize>> prizeMap, LottoPrize winningLottoPrize) {
        final int prize = winningLottoPrize.getPrizeAmount();
        final int countOfMatches = winningLottoPrize.getCountOfMatches();
        final List<LottoPrize> lottoMatchers = prizeMap.getOrDefault(winningLottoPrize, new ArrayList<>());

        if (winningLottoPrize.isBonus()) {
            System.out.printf("%d개 일치 보너스 볼 일치(%d원) - %d개%n", countOfMatches, prize, lottoMatchers.size());
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개%n", countOfMatches, prize, lottoMatchers.size());
    }

    private void printYield(final LottoGameStatistics lottoGameStatistics) {
        Double yield = lottoGameStatistics.calculateYield();
        System.out.printf("수익률은 %.2f입니다.", yield);
    }
}
