package lottery.view;

import lottery.domain.LotteryPrize;
import lottery.domain.LotteryTicket;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printPurchaseTickets(List<LotteryTicket> tickets) {
        for (LotteryTicket ticket : tickets) {
            System.out.println(ticket);
        }
        System.out.println();
    }

    public static void printResultStatistics(List<LotteryPrize> lotteryPrizes) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRanks(lotteryPrizes);
        printProfitRate(lotteryPrizes);
    }

    private static void printProfitRate(List<LotteryPrize> lotteryPrizes) {
        double profitRate = LotteryPrize.calculateProfitRate(lotteryPrizes);
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

    private static void printRanks(List<LotteryPrize> lotteryPrizes) {
        for (LotteryPrize prize : LotteryPrize.values()) {
            printRank(prize, Collections.frequency(lotteryPrizes, prize));
        }
    }

    private static void printRank(LotteryPrize prize, int count) {
        if (prize == LotteryPrize.NONE) {
            return;
        }
        System.out.println(prize.calculateMatchingCount()
                + "개 일치 (" + prize.calculatePrizeMoney()
                + "원) - " + count + "개");
    }
}
