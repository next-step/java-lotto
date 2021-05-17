package lotto.objects;

final public class Print {
    public static void printPurchase(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printStatistics() {
        System.out.println("당첨 통계\n---------");
    }

    public static void printResult(WinningStatistics winningStatistics, Counts counts, int index) {
        System.out.println(winningStatistics.getWinningTypes().get(index).getCorrespond() + "- " + counts.getCounts().get(index) + "개");
    }

    public static void printYield(Counts counts, WinningStatistics winningStatistics, int money) {
        int sum = 0;

        for (int i = 0; i < counts.getCounts().size(); i++) {
            sum += counts.getCounts().get(i) * winningStatistics.getWinningTypes().get(i).getWinningAmount();
        }

        double yield = (double) Math.round(sum * 100 / money) / 100.0;

        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
