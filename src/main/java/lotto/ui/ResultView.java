package lotto.ui;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.prize.Rank;
import lotto.domain.prize.WinningResult;

import java.util.stream.IntStream;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoTicket(int quantity, LottoTicket lottoTicket) {
        System.out.println(quantity + "개를 구매했습니다.");
        IntStream.range(0, quantity).forEach(i -> System.out.println(lottoTicket.tellLottoNumbers(i)));
        System.out.println();
    }

    public static void printWinningRate(double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "입니다.");
        if (winningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해의 의미임)");
        }
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n————");
        for (Rank rank : Rank.values()) {
            if(rank == Rank.MISS){
                continue;
            }
            int winningCount = winningResult.tellWinningCount(rank);
            System.out.println(rank + " - " + winningCount + "개");
        }
    }
}
