package step2.view;

import step2.domain.WinningCount;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLotteryNumbers(List<Integer> lotteryNumbers) {
        String result = lotteryNumbers.stream().map(Objects::toString).collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");
    }

    public static void result(int purchaseAmount, Map<WinningCount, Integer> winningCountMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalWinningAmount = 0;
        for (WinningCount winningCount : winningCountMap.keySet()) {
            totalWinningAmount += winningCount.getWinningAmount() * winningCountMap.get(winningCount);
            System.out.println(winningCount.getMatchingCount()
                    + "개 일치 (" + winningCount.getWinningAmount() + "원) - "
                    + winningCountMap.get(winningCount) + "개");
        }

        calculateRevenueRate(purchaseAmount, totalWinningAmount);
    }

    private static void calculateRevenueRate(int purchaseAmount, int totalWinningAmount) {
        double revenueRate = Math.floor((totalWinningAmount / (double) purchaseAmount) * 100) / 100;
        System.out.println("총 수익률은 " + revenueRate + "입니다.");
    }
}
