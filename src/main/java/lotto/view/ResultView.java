package lotto.view;

import lotto.model.WinningInfo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {
    private ResultView() {
    }

    public static void printCanBuyLottoCount(int canBuyLottoCount) {
        System.out.println(canBuyLottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Integer> lotto) {
        Collections.sort(lotto);

        System.out.println(lotto);
    }

    public static void printWinningStatics(Map<Integer, WinningInfo> winningStatics) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (int rank = 5; rank >= 1; rank--) {
            WinningInfo info = winningStatics.get(rank);

            int matchCount = info.getMatchCount();
            int prize = info.getPrize();
            int winningCount = info.getWinningCount();

            printWinningResult(rank, matchCount, prize, winningCount);
        }
    }

    private static void printWinningResult(int rank, int matchCount, int prize, int winningCount) {
        String resultMessage = matchCount + "개 일치 (" + prize + "원)- " + winningCount + "개";

        if (rank == 2) {
            resultMessage = matchCount + "개 일치, 보너스 볼 일치(" + prize + "원)- " + winningCount + "개";
        }

        System.out.println(resultMessage);
    }


    public static void printReturnRate(float returnRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "입니다.");
    }
}
