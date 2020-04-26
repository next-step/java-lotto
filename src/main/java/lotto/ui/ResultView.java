package lotto.ui;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class ResultView {

    private static final String BUY_RESULT = "%d개를 구매했습니다.";
    private static final String RESULT_PRINT_START_STR = "\n당첨 통계";
    private static final String DIVIDER = "---------";
    private static final String RESULT_MATCH_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String RESULT_MATCH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String RATE_FORMAT = "총 수익률은 %.2f입니다.";

    public static void buyResult(Lottos lottos) {
        printBuyCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos()
                .stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    private static void printBuyCount(int buyCount) {
        System.out.println(String.format(BUY_RESULT, buyCount));
    }

    public static void printResults(MatchResult result, Money money) {
        System.out.println(RESULT_PRINT_START_STR);
        System.out.println(DIVIDER);

        List<Rank> ranks = Rank.winningValues();
        ranks.sort(Comparator.reverseOrder());
        for (Rank rank : ranks) {
            printResultFormat(rank, result.getRankCount(rank));
        }
        printRateOfReturn(result.rateOfReturn(money));
    }

    private static void printRateOfReturn(BigDecimal rateOfReturn) {
        System.out.println(String.format(RATE_FORMAT, rateOfReturn));
    }

    private static void printResultFormat(Rank rank, int matchCount) {
        String format = RESULT_MATCH_FORMAT;
        if (rank == Rank.SECOND) {
            format = RESULT_MATCH_BONUS_FORMAT;
        }
        System.out.println(String.format(format, rank.getMatchCount(), rank.getPrizeMoney(), matchCount));
    }

}
