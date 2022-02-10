package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.LottoStatistic;
import lotto.domain.LottoTicket;
import lotto.domain.LottoRank;

public class ResultView {

    private ResultView() {

    }

    public static void printNumOfLottoTickets(int ticketSize) {
        System.out.println(ticketSize + "개를 구매했습니다.");
    }

    public static void printLottoTicketsInfo(List<LottoTicket> tickets) {
        tickets.forEach(ticket -> {
            System.out.println(ticket.toString());
        });
    }

    public static void printStatistic(LottoStatistic lottoStatistic) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoStatistic);
    }

    public static void printProfit(BigDecimal profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
