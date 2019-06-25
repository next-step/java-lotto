package step2.view;

import step2.LottoRank;
import step2.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printNumberOfLottoTickets(int numberOfLottoTicketsToBuy) {
        System.out.println(numberOfLottoTicketsToBuy + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {

                lottoTickets.stream()
                    .map(LottoTicket::getLottoTicket)
                    .forEach(System.out::println);

    }

    public static void printResult(Map<LottoRank, List<LottoTicket>> lottoResult, int numberOfTotalTickets) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        int totalPrizeMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrizeMoney += rank.getPrizeMoney();
            System.out.println(String.format("%d개 일치 (%d원) - %d개",
                    rank.getNumberOfMatchedToLuckyNumber(),
                    rank.getPrizeMoney(),
                    lottoResult.getOrDefault(rank, new ArrayList<>()).size()));
        }

        System.out.println(String.format("총 수익률은 %f 입니다.",
                (double) totalPrizeMoney / numberOfTotalTickets * 1000));
    }

}
