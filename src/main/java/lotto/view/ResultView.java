package lotto.view;

import java.util.List;
import lotto.domain.LottoStatistic;
import lotto.domain.LottoTicket;

public class ResultView {

    private ResultView() {

    }

    public static void printNumOfLottoTickets(int ticketSize) {
        System.out.println(ticketSize + "개를 구매했습니다.");
    }

    public static void printLottoTicketsInfo(List<LottoTicket> tickets) {
        tickets.forEach(ticket -> System.out.println(ticket.toString()));
    }

    public static void printStatistic(LottoStatistic lottoStatistic) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoStatistic);
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
