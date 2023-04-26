package lottery.view;

import lottery.domain.LotteryPrize;
import lottery.domain.LotteryTicket;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchaseCount(int manualCount, int randomCount) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + randomCount + "장을 구매했습니다.");
    }

    public static void printPurchaseTickets(List<LotteryTicket> tickets) {
        for (LotteryTicket ticket : tickets) {
            System.out.println(addBrackets(ticket.toString()));
        }
        System.out.println();
    }

    private static String addBrackets(String string) {
        return "[" + string + "]";
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
        System.out.println();
    }

    private static void printRank(LotteryPrize prize, int count) {
        if (prize == LotteryPrize.NONE) {
            return;
        }
        System.out.print(prize.calculateMatchingCount() + "개 일치");
        if (prize.IsBonusMatched()) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + prize.calculatePrizeMoney() + "원) - " + count + "개");
    }
}
