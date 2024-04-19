package lotto.view;

import lotto.domain.LottoPrize;

import java.util.Map;

public class ResultView {

    public void printPurchaseTickets(int purchaseCount) {
        System.out.println( purchaseCount + "개를 구매했습니다.");

    }

    public void printPrizeStatistics(Map<Integer, Integer> prizeCounts) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoPrize prize : LottoPrize.values()) {
            int count = prizeCounts.getOrDefault(prize.getMatchCount(), 0);
            System.out.printf("%d개 일치 (%d원)- %d개\n", prize.getMatchCount(), prize.getPrizeAmount(), count);
        }
    }
}
