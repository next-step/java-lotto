package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResults;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LottoOutputView {

    public static final String SECOND_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    public static final String DEFAULT_PRINT_FORMAT = "%d개 일치 (%d원)- %d개";

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
        Arrays.stream(Rank.values()).forEach(rank -> {
            int matchCount = matchingStats.get(rank);
            printRankResult(rank, matchCount);
        });
    }

    private static void printRankResult(Rank rank, int matchCount) {
        if (rank == Rank.SECOND) {
            System.out.printf(SECOND_RANK_PRINT_FORMAT, rank.matchCount(), rank.reward(), matchCount);
            return;
        }
        System.out.printf(DEFAULT_PRINT_FORMAT, rank.matchCount(), rank.reward(), matchCount);
    }

    public static void printWinningRatio(double winningRatio) {
        System.out.printf("총 수익률은 %s입니다.", new DecimalFormat("#.##").format(winningRatio));
        if (winningRatio < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
