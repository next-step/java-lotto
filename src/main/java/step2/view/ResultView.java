package step2.view;

import step2.domain.LottoNumber;
import step2.domain.Rank;

import java.util.*;

public class ResultView {
    private static final String INIT_MESSAGE = "\n당청 통계\n---------";

    private static final String REVENUE_RATIO_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.(기준값 1보다 높으면 이익, 낮으면 손해라는 의미임)";

    private static final String MATCH_MESSAGE_FORMAT = "%s (%d원)- %d개\n";

    private static final List<Rank> MATCH_PRINT_EXCLUDE_RANKS = List.of(Rank.MISS);

    public void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
        printEndLottoNumbers();
    }

    public void printCountByRank(Map<Rank, Long> countByRank) {
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

    private void printMatch(Map<Rank, Long> countByRanks) {
        Map<Rank, Long> descMap = sortByDesc(countByRanks);
        descMap.entrySet().forEach(this::printMatch);
    }

    private Map<Rank, Long> sortByDesc(Map<Rank, Long> countByRanks) {
        Map<Rank, Long> descMap = new TreeMap<>(Collections.reverseOrder());
        descMap.putAll(countByRanks);
        return descMap;
    }

    private void printMatch(Map.Entry<Rank, Long> countByRank) {
        if (!MATCH_PRINT_EXCLUDE_RANKS.contains(countByRank.getKey())) {
            System.out.printf(
                    MATCH_MESSAGE_FORMAT,
                    countByRank.getKey().getMatchMessage(),
                    countByRank.getKey().getWinningMoney(),
                    countByRank.getValue()
            );
        }
    }
}
