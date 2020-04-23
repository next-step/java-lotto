package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Match;
import lotto.domain.MatchResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

public class ResultView {

    private static final String BUY_RESULT = "%d개를 구매했습니다.";
    private static final String RESULT_PRINT_START_STR = "\n당첨 통계";
    private static final String DIVIDER = "---------";
    private static final String RESULT_MATCH_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String RATE_FORMAT = "총 수익률은 %f입니다.";

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

    public static void printResults(MatchResult result, int money) {
        System.out.println(RESULT_PRINT_START_STR);
        System.out.println(DIVIDER);

        List<Match> matches = Match.winningValues();
        matches.sort(Comparator.reverseOrder());
        for (Match match : matches) {
            printResultFormat(match, result.getMatchCount(match));
        }
        printRateOfReturn(result.rateOfReturn(money));
    }

    private static void printRateOfReturn(BigDecimal rateOfReturn) {
        System.out.println(String.format(RATE_FORMAT, rateOfReturn));
    }

    private static void printResultFormat(Match match, int matchCount) {
        System.out.println(String.format(RESULT_MATCH_FORMAT, match.getMatchCount(), match.getPrizeMoney(), matchCount));
    }

}
