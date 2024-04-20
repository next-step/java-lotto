package lotto.view;

import lotto.domain.LottoPrize;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printPurchaseTickets(int purchaseCount) {
        System.out.println( purchaseCount + "개를 구매했습니다.");

    }

    public static void printGenerateTickets(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public static void printPrizeStatistics(Map<Integer, Integer> prizeCounts) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCounts.getOrDefault(prize.getMatchCount(), 0);
            System.out.printf("%d개 일치 (%d원)- %d개\n", prize.getMatchCount(), prize.getPrizeAmount(), count);
        }
    }

    public static void printReturnRate(double returnRate) {
        double flooredRate = Math.floor(returnRate * 100) / 100.0; // 소수점 두 번째 자리까지 버림
        String resultMessage = (returnRate < 1) ? "손해" : "이득";

        System.out.println("총 수익률은 " + String.format("%.2f", flooredRate) + "입니다. (기준이 1이기 때문에 결과적으로 " + resultMessage + "(이)라는 의미임)");
    }
}
