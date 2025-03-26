package lotto.view;

import lotto.domain.Division;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchaseList(List<List<Integer>> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (List<Integer> lotto: lottos) {
            System.out.println(lotto);
        }
         System.out.println();
    }

    public static void printWinningResult(Map<Division, Integer> winnerCountMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<Division, Integer> entry: winnerCountMap.entrySet()) {
            System.out.println(entry.getKey().getPrintMessage() + entry.getValue() + "개");
        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", earningRate);
    }
}
