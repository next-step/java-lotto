package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.number.Ticket;
import lotto.domain.winner.WinningCondition;
import lotto.domain.winner.WinningReport;

public class LottoResultView {

    private LottoResultView() {

    }

    public static void printTicketCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static void printTickets(TicketBox ticketBox) {
        for (Ticket ticket : ticketBox.getTickets()) {
            System.out.println("[" +
                    ticket.getLottoBalls()
                            .getBalls()
                            .stream()
                            .map(ball -> String.valueOf(ball.getNumber()))
                            .collect(Collectors.joining(", ")) +
                    "]");
        }
    }

    public static void printResultStatics(WinningReport winningReport, PurchasePrice purchase) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinningResult(winningReport);
        printRateOfReturn(winningReport, purchase);
    }

    private static void printWinningResult(WinningReport winningReport) {
        for (WinningCondition condition : WinningCondition.getConditionsWithPrize()) {
            System.out.printf(resultFormat(condition),
                    condition.getMatchCount(),
                    condition.getPrizeMoney(),
                    winningReport.getWinningCount(condition));
        }
    }

    private static String resultFormat(WinningCondition condition) {
        String format = "%d개 일치";
        if(condition.getRequiredBonus() && condition.getBonusMatch()) {
            format = format.concat(", 보너스 볼 일치");
        }
        format = format.concat("(%d원)- %d개%n");
        return format;
    }

    private static void printRateOfReturn(WinningReport winningReport, PurchasePrice purchase) {
        double rateOfReturn = winningReport.getRateOfReturn(purchase);
        System.out.printf("총 수익률은 %.2f입니다.", rateOfReturn);
        if (rateOfReturn < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
