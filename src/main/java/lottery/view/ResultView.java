package lottery.view;

import lottery.Lottery;
import lottery.LotteryRank;
import lottery.LotteryResult;

import java.util.List;

public class ResultView {

    public static void printPurchasedLotteryInfos(List<Lottery> lotteries) {
        printPurchasedLotteryAmount(lotteries.size());
        printPurchasedLotteryNumbers(lotteries);
    }

    private static void printPurchasedLotteryAmount(int purchasedLotteryAmount) {
        System.out.println(purchasedLotteryAmount + "개를 구매했습니다.");
    }

    private static void printPurchasedLotteryNumbers(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.getLotteryNumbers());
        }
        System.out.println();
    }

    public static void printLotteryResult(LotteryResult lotteryResult) {
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("--------");

        printLotteryResultsPerRanks(lotteryResult);

        System.out.printf("총 수익률은 %.2f 입니다.", lotteryResult.getReturnRate());
    }

    private static void printLotteryResultsPerRanks(LotteryResult lotteryResult) {
        for (int rank : LotteryRank.getUsedRanks()) {
            int prizeOfRank = LotteryRank.getPrizeOfRank(rank);
            int winningCountOfRank = lotteryResult.getWinningCountOfRank(rank);

            System.out.println(rank + "개 일치 (" + prizeOfRank + ") - " + winningCountOfRank + "개");
        }
    }

}
