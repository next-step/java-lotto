package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.Rank;
import lotto.model.WinningReport;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OutputView {

    private static final String BUY_TICKET_MSG = "개를 구매했습니다.";
    private static final String REPORT_START_MSG = "당첨 통계";
    private static final String REPORT_DIVIDING_LINE = "---------";
    private static final String REPORT_PROFIT_RATE_MSG = "총 수익률은 %.2f입니다.";
    private static final String REPORT_STATISTICS_MSG = "%d개 일치%s(%d원) - %d개";
    private static final String BONUS_NUMBER_MATCH_MSG = ", 보너스 볼 일치";
    private static final String BLANK = " ";

    public static void printLottoTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + BUY_TICKET_MSG);
        for (LottoTicket ticket : tickets) {
            System.out.println(transformNumberToFormat(ticket.getNumbers()));
        }
    }

    private static String transformNumberToFormat(List<Integer> lottoNumbers) {
        StringBuilder result = new StringBuilder("[");
        for (int number : lottoNumbers) {
            result.append(number).append(", ");
        }
        result.setLength(result.length() - 2);
        result.append("]");
        return result.toString();
    }

    public static void printReport(WinningReport report) {
        System.out.println(REPORT_START_MSG);
        System.out.println(REPORT_DIVIDING_LINE);

        printStatistics(report);
        printProfitRate(report.getProfitRate());
    }

    private static void printProfitRate(double profitRate) {
        System.out.println(String.format(REPORT_PROFIT_RATE_MSG, profitRate));
    }

    private static void printStatistics(WinningReport report) {
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.MISS)
                .forEach(rank -> {
                    System.out.println(makeMessageByRank(rank, report.getRankCount(rank)));
                });
    }

    private static String makeMessageByRank(Rank rank, int winningCount) {
        if (rank == Rank.SECOND) {
            return String.format(REPORT_STATISTICS_MSG, rank.getMatch(), BONUS_NUMBER_MATCH_MSG, rank.getWinningBonus(), winningCount);
        }
        return String.format(REPORT_STATISTICS_MSG, rank.getMatch(), BLANK, rank.getWinningBonus(), winningCount);
    }
}