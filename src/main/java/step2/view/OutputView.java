package step2.view;

import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.WinningCount;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        String result = lottoNumbers.get(0).getNumbers()
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + result + "]");
    }

    public static void result(int purchaseAmount, Map<WinningCount, Integer> winningCountMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalWinningAmount = 0;
        for (WinningCount winningCount : winningCountMap.keySet()) {
            if (winningCount.getMatchingCount() == 0) {
                return;
            }
            totalWinningAmount += winningCount.getWinningAmount() * winningCountMap.get(winningCount);
            System.out.println(winningCount + " - " + winningCountMap.get(winningCount) + "개");
        }

        calculateRevenueRate(purchaseAmount, totalWinningAmount);
    }

    private static void calculateRevenueRate(int purchaseAmount, int totalWinningAmount) {
        double revenueRate = Math.floor((totalWinningAmount / (double) purchaseAmount) * 100) / 100;
        System.out.println("총 수익률은 " + revenueRate + "입니다.");
    }
}
