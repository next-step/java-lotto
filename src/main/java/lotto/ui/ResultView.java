package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Match;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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

    public static void printResults(Map<Match, Integer> result, int money) {
        System.out.println(RESULT_PRINT_START_STR);
        System.out.println(DIVIDER);

        // TODO: 로직을 외부로 이동. (출력만 수행)
        int totalPrize = 0;
        List<Match> matches = Match.winningValues();
        matches.sort(Comparator.reverseOrder());
        for (Match match : matches) {
            printResultFormat(match.getMatchCount(), match.getPrizeMoney(), result.get(match));
            totalPrize += match.getPrizeMoney() * result.get(match);
        }
        BigDecimal bigDecimal1 = new BigDecimal(money);
        BigDecimal bigDecimal2 = new BigDecimal(totalPrize);
        BigDecimal rateOfReturn = bigDecimal2.divide(bigDecimal1, 2, RoundingMode.HALF_UP);

        printRateOfReturn(rateOfReturn);
    }

    private static void printRateOfReturn(BigDecimal rateOfReturn) {
        System.out.println(String.format(RATE_FORMAT, rateOfReturn));
    }

    private static void printResultFormat(int match, int prizeMoney, int matchCount) {
        System.out.println(String.format(RESULT_MATCH_FORMAT, match, prizeMoney, matchCount));
    }

}
