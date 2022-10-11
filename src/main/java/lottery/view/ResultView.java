package lottery.view;

import lottery.Lottery;
import lottery.LotteryResult;
import lottery.LotteryWallet;

import java.util.List;

public class ResultView {

    public static void printPurchasedLotteryAmount(int purchasedLotteryAmount) {
        System.out.println(purchasedLotteryAmount + "개를 구매했습니다.");
    }

    public static void printPurchasedLotteryNumbers(LotteryWallet lotteryWallet) {
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

        int[] printRanks = {3, 4, 5, 6};
        for (int printRank : printRanks) {
            int prizeOf = lotteryResult.getPrizeOf(printRank);
            int wonAmountOf = lotteryResult.getWonAmountOf(printRank);
            System.out.println(printRank + "개 일치 (" + prizeOf + ") - " + wonAmountOf + "개");
        }

        System.out.printf("총 수익률은 %.2f 입니다.", lotteryResult.getReturnRate());
    }

}
