package view;

import java.util.Arrays;
import java.util.List;

import domain.WinningPrizes;
import domain.WinningStatistics;

public class LottoOutputView {

    public static void printBeforeWinnings() {
        printStatistics();
        printDash(9);
        System.out.println();
    }

    public static void printMatchCount(int match) {
        System.out.print(match + "개 일치");
    }

    public static void printBonus() {
        System.out.print(", 보너스 볼 일치");
    }

    public static void printMatchRank(int rank) {
        LottoOutputView.printMatchCount(rank);
        LottoOutputView.printSpace();
    }

    public static void printPrizes(int prize) {
        LottoOutputView.printPrize(prize);
        LottoOutputView.printDash(1);
        LottoOutputView.printSpace();
    }

    public static void printSecondPrizes(int prize) {
        LottoOutputView.printPrize(prize);
        LottoOutputView.printBonus();
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
            Arrays.stream(lottoResult).sorted();
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

    public static void printSecondPrize(WinningPrizes prizes, int count) {
        printMatchRank(prizes.getRank());
        printSecondPrizes(prizes.getPrizeMoney());
        printWinningCount(count);
    }

    public static void printPrize(WinningPrizes prize, int count) {
        printMatchRank(prize.getRank());
        printPrizes(prize.getPrizeMoney());
        printWinningCount(count);
    }

    public static void printEachPrize(WinningPrizes prize, int count) {
        if (WinningPrizes.MISS == prize) {
            return;
        }

        if (WinningPrizes.SECOND_PRIZE == prize) {
            printSecondPrize(prize, count);
            return;
        }

        printPrize(prize, count);
    }

    public static void printWinnings(WinningStatistics winningStatistics) {
        for (WinningPrizes prize : winningStatistics.getWinningResults().keySet()) {
            int count = winningStatistics.getWinningResults().get(prize);
            printEachPrize(prize, count);
        }
    }
}
