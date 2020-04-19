package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Match;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";

    public static void buyResult(List<Lotto> lottos) {
        printBuyCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    private static void printBuyCount(int buyCount) {
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public static void printResults(Map<Match, Integer> result, int money) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        int totalPrize = 0;
        List<Match> matches = Match.winningValues();
        matches.sort(Comparator.reverseOrder());
        for (Match match : matches) {
            printResultFormat(match.getMatchCount(), match.getPrizeMoney(), result.get(match));
            totalPrize += match.getPrizeMoney() * result.get(match);
        }
        printRateOfReturn(money, totalPrize);
    }

    private static void printRateOfReturn(int money, int totalPrize) {
        double rateOfReturn = totalPrize / (double) money;
        System.out.println(String.format("총 수익률은 %.2f입니다.", rateOfReturn));
    }

    private static void printResultFormat(int match, int prizeMoney, int matchCount) {
        System.out.println(String.format(RESULT_FORMAT, match, prizeMoney, matchCount));
    }

}
