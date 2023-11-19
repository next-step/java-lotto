package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printPurchasedLottoNumbers(List<List<Integer>> lottoNumbers) {
        for(List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    public static void printPurchaseCount(int input) {
        System.out.println(input + "개를 구매했습니다.");
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계\n---------");
    }

    public static void showLottoResult(HashMap<Rank, Integer> lottoResult, int purchaseAmount) {
        long sum = 0;
        printWinningStatistics();
        for (Rank rank : lottoResult.keySet()) {
            sum += rank.getPrize() * lottoResult.get(rank);
            printWinningResult(rank.getCount(), rank.getPrize(), lottoResult.get(rank));
        }
        double percentage = sum / (double) purchaseAmount;
        printProfitPercentage(percentage);
    }

    public static void printWinningResult(int result, long prize, int count) {
        if (prize == 0) {
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개\n", result, prize, count);
    }

    public static void printProfitPercentage(double percentage) {
        System.out.printf("총 수익률은 %.2f입니다.", percentage);
    }
}
