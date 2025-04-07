package Lotto.view;

import Lotto.constants.LottoPrize;
import Lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static String format(Lotto lotto) {
        return lotto.toString();
    }

    public static void printQuantity(int quantity) {
        System.out.println(quantity+"개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(format(lotto)));
    }

    public static void printStats(Map<LottoPrize, Integer> stats) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (LottoPrize prize : LottoPrize.values()) {
            int count = stats.getOrDefault(prize, 0);
            System.out.println(prize + " - " + count + "개");
        }
    }


    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
    }
}
