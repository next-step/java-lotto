package lotto.view;

import java.util.List;
import lotto.domain.LottoStatistic;
import lotto.domain.LottoTicket;

public class ResultView {

    private ResultView() {

    }

    public static void printBuyingInformation(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
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
