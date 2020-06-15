package lotto.ui;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.prize.Rank;
import lotto.domain.prize.WinningResult;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoTicket(int quantity, int manualCount, LottoTicket lottoTicket) {
        System.out.println("\n수동으로 " + manualCount + "장, 자동으로 " + (quantity - manualCount) + "개를 구매했습니다.");
        IntStream.range(0, quantity)
                .mapToObj(x -> lottoTicket.tellLottoNumbers(x))
                .forEach(System.out::println);
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n————");

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .map(rank -> {
                    String matchStr = rank == Rank.SECOND ? "개 일치, 보너스 볼 일치(" : "개 일치 (";
                    return rank.getCountOfMatch() + matchStr + rank.getWinningMoney() + "원) - " + winningResult.tellWinningCount(rank) + "개";
                })
                .sorted()
                .forEach(System.out::println);
    }

    public static void printWinningRate(double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "입니다.");
        if (winningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해의 의미임)");
        }
    }
}
