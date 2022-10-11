package lottery.view;

import lottery.Lottery;
import lottery.LotteryResult;
import lottery.LotteryWallet;

import java.util.List;

public class ResultView {

    public static final int[] PRINT_RANKS = {3, 4, 5, 6};

    public static void printPurchasedLotteryInfos(LotteryWallet lotteryWallet) {
        printPurchasedLotteryAmount(lotteryWallet.getLotteries().size());
        printPurchasedLotteryNumbers(lotteryWallet);
    }

    private static void printPurchasedLotteryAmount(int purchasedLotteryAmount) {
        System.out.println(purchasedLotteryAmount + "개를 구매했습니다.");
    }

    private static void printPurchasedLotteryNumbers(LotteryWallet lotteryWallet) {
        List<Lottery> lotteries = lotteryWallet.getLotteries();
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
        for (int printRank : PRINT_RANKS) {
            int prizeOf = lotteryResult.getPrizeOf(printRank);
            int wonCountOf = lotteryResult.getWonCountOf(printRank);
            System.out.println(printRank + "개 일치 (" + prizeOf + ") - " + wonCountOf + "개");
        }
    }

}
