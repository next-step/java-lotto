package view;

import static domain.WinningPrizeMatchers.FIVE_BONUS;
import static domain.WinningPrizeMatchers.THRESHOLD;
import static domain.WinningPrizeMatchers.TWO;

import java.util.Arrays;
import java.util.List;

import domain.WinningPrizeMatchers;
import domain.WinningStatistics;

public class LottoOutputView {
    public static void printBeforeWinnings() {
        printStatistics();
        printDash(9);
        System.out.println();
    }

    public static void printMatchCount(WinningPrizeMatchers match) {
        System.out.print(match.getNumberOfCount() + "개 일치");
        if (FIVE_BONUS == match) {
            printBonus();
        }
    }

    public static void printBonus() {
        System.out.print(", 보너스 볼 일치");
    }

    public static void printMatch(WinningPrizeMatchers matchers) {
        LottoOutputView.printMatchCount(matchers);
        LottoOutputView.printSpace();
    }

    public static void printPrizes(int prize) {
        LottoOutputView.printPrize(prize);
        LottoOutputView.printDash(1);
        LottoOutputView.printSpace();
    }

    public static void printWinningCount(int count) {
        LottoOutputView.printCount(count);
        LottoOutputView.printSpace();
        LottoOutputView.printLine();
    }

    public static void printSpace() {
        System.out.print(" ");
    }

    public static void printPrize(int prize) {
        System.out.print("(" + prize + "원)");
    }

    public static void printDash(int count) {
        System.out.print("-".repeat(count));
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printGameCount(int gameCount) {
        printCount(gameCount);
        System.out.print("를 구매했습니다.");
        System.out.println();
    }

    public static void printStatistics() {
        System.out.println("당첨 통계");
    }

    public static void printCount(int count) {
        System.out.print(count + "개");
    }

    public static void printLottoResults(int gameCount, List<int[]> lottoResults) {
        printGameCount(gameCount);
        for (int[] lottoResult : lottoResults) {
            Arrays.sort(lottoResult);
            System.out.print("[");
            printEachLottoResult(lottoResult);
            System.out.println("]");
        }
    }

    private static void printEachLottoResult(int[] lottoResult) {
        for (int i = 0; i < lottoResult.length; i++) {
            System.out.print(lottoResult[i]);
            printComma(lottoResult, i);
        }
    }

    private static void printComma(int[] lottoResult, int i) {
        if (i < lottoResult.length - 1) {
            System.out.print(", ");
        }
    }

    public static void printReturnOnInvestment(float roi) {
        System.out.println("총 수익률은 " + roi + "입니다.");
    }


    public static void printEachPrize(WinningPrizeMatchers matchers, int count) {
        if (matchers.getNumberOfCount() == THRESHOLD) {
            return;
        }
        printMatch(matchers);
        printPrizes(matchers.calculateWinningPrize().getPrizeMoney());
        printWinningCount(count);
    }

    public static void printWinnings(WinningStatistics winningStatistics) {
        for (WinningPrizeMatchers matchers : winningStatistics.getWinningResults().keySet()) {
            int count = winningStatistics.getWinningResults().get(matchers);
            printEachPrize(matchers, count);
        }
    }
}
