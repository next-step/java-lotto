package step2;

import step2.domain.LottoRanking;
import step2.domain.ResultAnalyzer;
import step2.domain.Ticket;
import step2.domain.TicketSellingMachine;
import step2.lib.PrintMessage;
import step2.view.InputScanner;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TicketSellingMachine ticketSellingMachine = new TicketSellingMachine();

        int spendingMoney = InputScanner.getInt("구입금액을 입력해 주세요.");

        List<Ticket> tickets = ticketSellingMachine.buy(spendingMoney);
        PrintMessage.print("%s개를 구매했습니다.\n", tickets.size());
        PrintMessage.println();

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket));

        PrintMessage.println();
        int[] winningNumber = InputScanner.getInts("지난 주 당첨 번호를 입력해 주세요.");

        PrintMessage.println();
        PrintMessage.println("당첨 통계");
        PrintMessage.println("---------");

        for (LottoRanking ranking : LottoRanking.values()) {
            PrintMessage.print(
                    "%s개 일치 (%,d원)- %s개\n",
                    ranking.getHitCount(),
                    ranking.getPrizeMoney(),
                    ResultAnalyzer.getHitListCount(winningNumber, tickets, ranking.getHitCount())
            );
        }

        PrintMessage.print(
                "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n",
                ResultAnalyzer.getRateReturn(winningNumber, tickets, spendingMoney)
        );
    }
}
