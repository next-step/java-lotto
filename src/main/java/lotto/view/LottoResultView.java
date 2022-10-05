package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.TicketBox;
import lotto.domain.winner.WinningCondition;
import lotto.domain.winner.WinningReport;

public class LottoResultView {

    public static void printTicketCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static void printTickets(TicketBox ticketBox) {
        for (int i = 0; i < ticketBox.getSize(); i++) {
            System.out.println("[" +
                    ticketBox.getTicket(i)
                            .getNumbers()
                            .stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")) +
                    "]");
        }
    }

    public static void printResultStatics(WinningReport winningReport, int purchase) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinningResult(winningReport);
        printRateOfReturn(winningReport, purchase);
    }

    private static void printWinningResult(WinningReport winningReport) {
        for (WinningCondition condition : WinningCondition.getConditionsWithPrize()) {
            System.out.printf("%d개 일치 (%d원)- %d개%n",
                    condition.getMatchCount(),
                    condition.getPrizeMoney(),
                    winningReport.getWinningCount(condition));
        }
    }

    private static void printRateOfReturn(WinningReport winningReport, int purchase) {
        double rateOfReturn = winningReport.getRateOfReturn(purchase);
        System.out.printf("총 수익률은 %.2f입니다.", rateOfReturn);
        if (rateOfReturn < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
