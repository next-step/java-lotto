package lotto.view;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(String input) {
        System.out.println(input);
    }

    public static void printPurchaseCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계\n---------");
    }

    public static void printWinningResult(int result, long prize, int count) {
        if (prize == 0) {
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개\n", result, prize, count);
    }

    public static void printProfitPercentage(double percentage) {
        System.out.printf("총 수익률은 %.2f입니다.", percentage);
    }
}
