package Lotto.view;

import Lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printQuantity(int quantity) {
        System.out.println(quantity+"개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printStats(List<Integer> stats) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원) - " + stats.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + stats.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + stats.get(5) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + stats.get(6) + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
    }
}
