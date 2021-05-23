package step3.io;

import java.util.Map;

import step3.constant.Rank;

public class ConsoleResultView {
    private static final String BUY_TEXT = "개를 구매했습니다.";
    private static final String STATISTICS_TEXT = "당첨 통계";
    private static final String SEPERATOR_TEXT = "---------";
    private static final String COUNT_TEXT = "%d개 일치(%d원)-%d개";
    private static final String BENEFIT_TEXT = "총 수익률은 %s입니다.";

    public void showText(String message) {
        System.out.println(message);
    }

    public void buyCount(int size) {
        System.out.println(size + BUY_TEXT);
    }

    public void showWinning(Map<Rank, Long> winningWithNumbers) {
        System.out.println(STATISTICS_TEXT);
        System.out.println(SEPERATOR_TEXT);
        printWinningOne(Rank.FOURTH, winningWithNumbers);
        printWinningOne(Rank.THIRD, winningWithNumbers);
        printWinningOne(Rank.SECOND, winningWithNumbers);
        printWinningOne(Rank.FIRST, winningWithNumbers);

    }

    private void printWinningOne(Rank winnerPrice, Map<Rank, Long> winningWithNumbers) {

        System.out.printf(COUNT_TEXT, winnerPrice.matchedCount(), winnerPrice.winnerPrice(),
                winningWithNumbers.getOrDefault(winnerPrice, 0L));
        System.out.println();

    }

    public void showEmptyLine() {
        System.out.println();
    }

    public void showBenefit(String benefit) {
        System.out.printf(BENEFIT_TEXT, benefit);
        System.out.println();
    }

}
