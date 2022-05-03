package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Ranking;

import java.util.Collections;
import java.util.Map;

public class ResultView {
    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계\n---------";
    private static final String RANKING_RESULT_MESSAGE = "%s- %d개";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
    private ResultView() {
    }

    public static void printPurchaseMessage(Lottos lottos, int purchaseCount) {
        System.out.printf((PURCHASE_RESULT_MESSAGE) + "%n", purchaseCount);
        System.out.println(lottos.toString());
    }

    public static void printWinningMessage(Map<Ranking, Integer> winningMap, int purchasePrice) {
        System.out.println(WINNING_RESULT_MESSAGE);
        winningMap.keySet()
                .stream()
                .sorted(Collections.reverseOrder())
                .forEach(ranking -> System.out.printf((RANKING_RESULT_MESSAGE) + "%n", ranking.toString(), winningMap.get(ranking)));

        System.out.printf((TOTAL_YIELD_MESSAGE) + "%n", calculateTotalPrice(winningMap) / purchasePrice);
    }

    private static double calculateTotalPrice(Map<Ranking, Integer> winningMap) {
        return winningMap.keySet()
                .stream().map(ranking -> ranking.getPriceByCount(winningMap.get(ranking)))
                .mapToInt(i -> i)
                .sum();
    }
}
