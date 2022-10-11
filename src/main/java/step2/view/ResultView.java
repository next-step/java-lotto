package step2.view;

import step2.domain.Analyst;
import step2.domain.LottoNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private static final String INIT_MESSAGE = "\n당청 통계\n---------";

    private static final String REVENUE_RATIO_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.(기준값 1보다 높으면 이익, 낮으면 손해라는 의미임)";

    private static final String MATCH_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개\n";

    private static final int PRINT_START_REVENUE = 3;

    private static final int PRINT_END_REVENUE = 7;

    public void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
        printEndLottoNumbers();
    }

    public void printCountByRank(Map<Integer, Long> countByRank) {
        printInitMessage();
        printMatch(countByRank);
    }

    public void printRevenueRatio(float revenueRatio) {
        System.out.printf(REVENUE_RATIO_MESSAGE_FORMAT, revenueRatio);
    }

    private void printEndLottoNumbers() {
        System.out.println();
    }

    private void printInitMessage() {
        System.out.println(INIT_MESSAGE);
    }

    private void printMatch(Map<Integer, Long> countByRank) {
        IntStream.range(PRINT_START_REVENUE, PRINT_END_REVENUE)
                .forEach(revenue -> {
                    int count = countByRank.get(revenue) == null ? 0 : countByRank.get(revenue).intValue();
                    printMatch(revenue, Analyst.REVENUE_TABLE.get(revenue), count);
                });
    }

    private void printMatch(int lottoMatch, int revenue, int matchCount) {
        System.out.printf(MATCH_MESSAGE_FORMAT, lottoMatch, revenue, matchCount);
    }
}
