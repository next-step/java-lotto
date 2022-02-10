package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
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

    public static void printStatistic(Map<LottoRank, Integer> resultMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Stream.of(LottoRank.values())
            .forEach(rank -> {
                int rankValue = 0;
                if (resultMap.containsKey(rank)) {
                    rankValue = resultMap.get(rank);
                }
                System.out.println(
                    rank.getRankString()
                        + " (" + rank.getWinningAmount() + ")- "
                        + rankValue + "개");

            });
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }
}
