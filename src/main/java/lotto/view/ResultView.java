package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.Rank;

import java.util.List;

public class ResultView {

    public void printMyTicket(List<String> toStringTickets) {
        int ticketCount = toStringTickets.size();
        System.out.println(ticketCount + "개를 구매했습니다.");

        for (String ticketToString : toStringTickets) {
            System.out.println(ticketToString);
        }
        printNewLine();
    }

    public void printLottoStatistics(LottoStatistics statistics){
        printWinCounts(statistics.getWinCounts());
        printWinPercent(statistics.getWinPercents());
    }

    private void printWinCounts(int[] winCounts) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (int i = winCounts.length - 1; i >= 0; i--) {
            Rank rank = Rank.findByOrder(i);
            String result = String.format("%d개 일치 (%d원)- %d개", rank.getMatchCount(), rank.getWinMoney(), winCounts[i]);

            if (rank == Rank.MISS) {
                continue;
            }
            if (rank == Rank.MISS.SECOND) {
                result = String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", rank.getMatchCount(), rank.getWinMoney(), winCounts[i]);
            }

            System.out.println(result);
        }
    }

    private void printWinPercent(double winPercent) {
        System.out.println("총 수익률은" + winPercent + "입니다.");
    }

    private void printNewLine() {
        System.out.println();
    }
}
