package lotto.view;

import lotto.LottoResult;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.enums.Rank;

import java.util.Map;

public class LottoResultView {
    public static void printTicket(Tickets tickets) {
        for (Ticket ticket : tickets.getTickets()) {
            System.out.println(ticket);
        }
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨결과\n================================");
        for (Map.Entry<Rank, Integer> entry : lottoResult.getWinningCountPerRank().entrySet()) {
            System.out.printf("%d개 일치(%d원) - %d개%n", entry.getKey().getMatchCount(), entry.getKey().getPrizeAmount(), entry.getValue());
        }
        System.out.printf("총 수익률은 %.2f 입니다.%n", lottoResult.getRateOfReturn());
    }
}
