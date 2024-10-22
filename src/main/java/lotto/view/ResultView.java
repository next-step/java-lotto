package lotto.view;

import lotto.common.WinningInfo;

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

    public static void printWinningStatics(Map<Integer, Integer> winningStatics) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (int rank = 5; rank >= 1; rank--) {
            int matchCount = WinningInfo.MATCH_COUNT[rank];
            int prize = WinningInfo.PRIZE[rank];

           printWinningResult(rank, matchCount, prize, winningStatics);
        }
    }

    private static void printWinningResult(int rank, int matchCount, int prize, Map<Integer, Integer> winningStatics) {
        if (rank == 2) {
            System.out.println(matchCount + "개 일치, 보너스 볼 일치(" + prize + "원)- " + winningStatics.get(rank) + "개");
            return;
        }

        System.out.println(matchCount + "개 일치 (" + prize + "원)- " + winningStatics.get(rank) + "개");
    }

    public static void printReturnRate(float returnRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "입니다.");
    }
}
