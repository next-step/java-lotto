package lottery.view;

import lottery.Lottery;
import lottery.LotteryRank;
import lottery.LotteryResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {

    public static void printPurchasedLotteryInfos(List<Lottery> lotteries, int manuallyPurchasedAmount) {
        printPurchasedLotteryAmount(lotteries.size() - manuallyPurchasedAmount, manuallyPurchasedAmount);
        printPurchasedLotteryNumbers(lotteries);
    }

    public static void printResult(LotteryResult lotteryResult) {
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("--------");

        for (LotteryRank lotteryRank : getLotteryRanksToPrint()) {
            System.out.println(generateResultMessage(lotteryRank, lotteryResult.getWinningCountOfRank(lotteryRank)));
        }

        System.out.printf("총 수익률은 %.2f 입니다.", lotteryResult.getReturnRate());
    }

    private static void printPurchasedLotteryAmount(int randomlyPurchasedAmount, int manuallyPurchasedAmount) {
        System.out.println("수동으로 " + manuallyPurchasedAmount + "장, 자동으로 " + randomlyPurchasedAmount + "개를 구매했습니다.");
    }

    private static void printPurchasedLotteryNumbers(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.getLotteryNumbers());
        }
        System.out.println();
    }

    private static List<LotteryRank> getLotteryRanksToPrint() {
        return Stream.of(LotteryRank.values())
                .filter(r -> !r.equals(LotteryRank.NONE))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toUnmodifiableList());
    }

    private static String generateResultMessage(LotteryRank lotteryRank, int winningCountOfRank) {
        int matchingCount = lotteryRank.getMatchingCount();
        int prizeOfRank = lotteryRank.getPrize();
        String bonusMessage = "";

        if (lotteryRank.equals(LotteryRank.SECOND)) {
            bonusMessage = ", 보너스볼 일치";
        }
        return matchingCount + "개 일치" + bonusMessage + "(" + prizeOfRank + "원) - " + winningCountOfRank + "개";
    }

}
