package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResults;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LottoOutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(LottoOutputView::printSortedLottoNumbers);
    }

    private static void printSortedLottoNumbers(Lotto lotto) {
        Set<LottoNumber> lottoNumbers = lotto.numbers();
        LinkedHashSet<LottoNumber> sortedNumbers = sortedLottoNumbers(lottoNumbers);
        System.out.println(sortedNumbers);
    }

    private static LinkedHashSet<LottoNumber> sortedLottoNumbers(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void printLottoResults(LottoResults lottoResults) {
        System.out.println("당첨 통계\n---------");
        printWinningStats(lottoResults.matchingStats());
    }

    private static void printWinningStats(Map<Rank, Integer> matchingStats) {
        Arrays.stream(Rank.values())
                .filter(Rank::isWin)
                .forEach(rank -> printRankStats(matchingStats, rank));
    }

    private static void printRankStats(Map<Rank, Integer> matchingStats, Rank rank) {
        System.out.printf("%d개 일치 (%d원)- %d개\n", rank.matchCount(), rank.reward(), matchingStats.get(rank));
    }

    public static void printWinningRatio(double winningRatio) {
        System.out.printf("총 수익률은 %s입니다.", new DecimalFormat("#.##").format(winningRatio));
        if (winningRatio < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
