package step2.view;

import step2.domain.CountsByRank;
import step2.domain.LottoNumber;
import step2.domain.Rank;

import java.util.*;

public class ResultView {
    private static final String INIT_MESSAGE = "\n당청 통계\n---------";

    private static final String REVENUE_RATIO_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.(기준값 1보다 높으면 이익, 낮으면 손해라는 의미임)";

    private static final String MATCH_MESSAGE_FORMAT = "%s (%d원)- %d개\n";

    private static final String MATCH_COUNT_MESSAGE_SUFFIX = "개 일치";

    private static final String BONUS_BALL_MATCH_MESSAGE_SUFFIX = ", 보너스 볼 일치";

    public void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
        printEndLottoNumbers();
    }

    public void printCountByRank(CountsByRank countsByRank, List<Rank> excludeRanks) {
        printInitMessage();
        printPartOfCount(countsByRank, excludeRanks);
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

    private void printPartOfCount(CountsByRank countsByRank, List<Rank> excludeRanks) {
        CountsByRank filteredCountsByRank = countsByRank.filter(excludeRanks);
        filteredCountsByRank.getCountsByRank()
                .forEach((key, value) -> System.out.printf(
                        MATCH_MESSAGE_FORMAT,
                        getMatchCountMessage(key),
                        key.getWinningMoney(),
                        value
                ));
    }

    private String getMatchCountMessage(Rank rank) {
        String matchCountMessage = rank.getCountOfMatch() + MATCH_COUNT_MESSAGE_SUFFIX;
        return addBonusBallMessage(rank, matchCountMessage);
    }

    private String addBonusBallMessage(Rank rank, String message) {
        if (rank == Rank.SECOND) {
            return message + BONUS_BALL_MATCH_MESSAGE_SUFFIX;
        }
        return message;
    }
}
