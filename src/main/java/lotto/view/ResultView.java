package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printMyTicket(List<String> toStringTickets, int manualTicketCount) {
        int ticketCount = toStringTickets.size();
        int autoTicketCount = ticketCount - manualTicketCount;
        System.out.println("수동으로 " + autoTicketCount + "장, 자동으로 " + autoTicketCount + "개를 구매했습니다.");

        for (String ticketToString : toStringTickets) {
            System.out.println(ticketToString);
        }
        printNewLine();
    }

    public void printLottoStatistics(LottoStatistics statistics) {
        printWinCounts(statistics.getWinCounts());
        printWinPercent(statistics.getWinPercents());
    }

    private void printWinCounts(Map<String, Integer> winCounts) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (int i = Rank.countRankType() - 1; i >= 0; i--) {
            Rank rank = Rank.findByOrder(i);
            String result = String.format("%d개 일치 (%d원)- %d개", rank.getMatchCount(), rank.getWinMoney(), winCounts.get(rank.name()));

            if (rank == Rank.MISS) {
                continue;
            }
            if (rank == Rank.SECOND) {
                result = String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개", rank.getMatchCount(), rank.getWinMoney(), winCounts.get(rank.name()));
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
