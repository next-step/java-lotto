package view;

import java.util.List;

public class LottoResponse {

    public static void printBeforeWinnings() {
        printStatistics();
        printDash(9);
        System.out.println();
    }

    public static void printMatchCount(int match) {
        System.out.print(match + "개 일치");
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

    public static void printLottoResults(List<int[]> lottoResults) {
        for (int[] lottoResult : lottoResults) {
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
}
