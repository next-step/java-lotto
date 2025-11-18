package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.List;

public class ResultView {
    public static void printTicketCount(int count) {
        System.out.println(String.format("%d개를 구매했습니다.", count));
    }

    public static void printLottoTickets(LottoTickets tickets) {
        List<Lotto> lottos = tickets.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(WinningResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankResult(Rank.FOURTH, result);
        printRankResult(Rank.THIRD, result);
        printRankResult(Rank.SECOND, result);
        printRankResult(Rank.FIRST, result);
    }

    private static void printRankResult(Rank rank, WinningResult result) {
        int matchCount = rank.getMatchCount();
        int winningAmount = rank.getWinningAmount();
        int count = result.getCountByRank(rank);
        System.out.println(String.format("%d개 일치 (%d원)- %d개", matchCount, winningAmount, count));
    }

    public static void printProfitRate(double profitRate) {
        System.out.print(String.format("총 수익률은 %.2f입니다.", profitRate));
        if (profitRate >= 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
