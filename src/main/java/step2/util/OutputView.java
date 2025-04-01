package step2.util;

import step2.lottery.Lotterys;
import step2.winning.Winning;
import step2.winning.WinningResults;

import java.util.stream.Collectors;

public class OutputView {
    public static void printPurchaseAmount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotteryNumbers(Lotterys lotterys) {
        for (int i = 0; i < lotterys.length(); i++) {
            System.out.println(
                    lotterys.getLottery(i).getLottoNumbers().stream()
                            .sorted()
                            .map(Object::toString)
                            .collect(Collectors.joining(", ", "[", "]")));
        }
        System.out.println();
    }
    public static void printWinningStatistics(WinningResults winningResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원)- " + winningResults.getWinningResult(Winning.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원)- " + winningResults.getWinningResult(Winning.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원)- " + winningResults.getWinningResult(Winning.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)- " + winningResults.getWinningResult(Winning.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + winningResults.getWinningResult(Winning.FIRST) + "개");
    }
    public static void printTotalPrize(int totalPrize, int total ) {
        System.out.println("총 수익률은 " + (float) totalPrize / total + "입니다.");
    }
}
