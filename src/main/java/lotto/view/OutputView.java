package lotto.view;

import lotto.domain.Division;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static Map<Division, String> printStringMap = new EnumMap<>(Division.class);

    static {
        printStringMap.put(Division.FIFTH, "3개 일치 (5000원)- ");
        printStringMap.put(Division.FOURTH, "4개 일치 (50000원)- ");
        printStringMap.put(Division.THIRD, "5개 일치 (1500000원)- ");
        printStringMap.put(Division.FIRST, "6개 일치 (2000000000원)- ");
    }

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
            System.out.println(printStringMap.get(entry.getKey()) + entry.getValue() + "개");
        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", earningRate);
    }
}
