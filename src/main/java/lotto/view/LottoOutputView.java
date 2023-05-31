package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoOutputView {

    public static final String PRINT_LOTTO_COUNT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
    public static final String WINNING_RESULT_TITLE = "당첨 통계\n---------";
    public static final String DEFAULT_RANK_PRINT_FORMAT = "%d개 일치 (%d원)- %d개\n";
    public static final String SECOND_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개\n";
    public static final String PRINT_TOTAL_GAIN_FORMAT = "총 수익률은 %s입니다.";
    public static final String PRINT_DESCRIBE_LOSE_FORMAT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottos(Lottos lottos) {
        System.out.printf(PRINT_LOTTO_COUNT_FORMAT, lottos.manualCount(), lottos.autoCount());
        lottos.allLottos().forEach(LottoOutputView::printSortedLottoNumbers);
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
        System.out.println(WINNING_RESULT_TITLE);
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
        System.out.printf(DEFAULT_RANK_PRINT_FORMAT, rank.matchCount(), rank.reward(), matchCount);
    }

    public static void printWinningRatio(double winningRatio) {
        System.out.printf(PRINT_TOTAL_GAIN_FORMAT, new DecimalFormat("#.##").format(winningRatio));
        if (winningRatio < 1) {
            System.out.print(PRINT_DESCRIBE_LOSE_FORMAT);
        }
    }
}
