package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.Rank;
import lotto.model.WinningReport;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String BUY_TICKET_MSG = "개를 구매했습니다.";
    private static final String REPORT_START_MSG = "당첨 통계";
    private static final String REPORT_DIVIDING_LINE = "---------";
    private static final String REPORT_PROFIT_RATE_MSG = "총 수익률은 %.2f입니다.";
    private static final String REPORT_STATISTICS_MSG = "%d개 일치 (%d원) - %d개";

    public static void printLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + BUY_TICKET_MSG);
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public static void printReport(WinningReport report) {
        System.out.println(REPORT_START_MSG);
        System.out.println(REPORT_DIVIDING_LINE);

        printStatistics(report.getStatistics());
        printProfitRate(report.getProfitRate());
    }

    private static void printProfitRate(double profitRate) {
        System.out.println(String.format(REPORT_PROFIT_RATE_MSG, profitRate));
    }

    private static void printStatistics(Map<Rank, Integer> statistics) {
        Rank[] ranks = {Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.SIXTH};

        for (Rank rank : ranks) {
            System.out.println(String.format(REPORT_STATISTICS_MSG, rank.getMatch(), rank.getWinningBonus(), statistics.get(rank)));
        }
    }


}
