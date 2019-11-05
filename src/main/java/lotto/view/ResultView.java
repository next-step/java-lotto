package lotto.view;

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

    public void printWinStatistics(List<String> StatisticsStrings) {
        printNewLine();
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (String statisticsString : StatisticsStrings) {
            System.out.println(statisticsString);
        }
    }

    public void printNewLine() {
        System.out.println();
    }
}
