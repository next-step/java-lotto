/*
 * ResultView.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.View;

import edu.nextstep.lottoauto.ticket.Prize;
import edu.nextstep.lottoauto.ticket.Ticket;
import edu.nextstep.lottoauto.ticketManager.WinningPrizeResult;

import java.util.List;

public class ResultView {
    public static void printTickets(List<Ticket> tickets) {
        System.out.println(tickets.size());
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printWinningPrizeResult(WinningPrizeResult winningPrizeResult) {
        System.out.println("\n당첨 통계\n---------");
        for(Prize prize : Prize.values()) {
            System.out.println(prize.getValue() + "개 일치 " +
                    "(" + prize.getPrize() + "원)- " +
                    winningPrizeResult.getWinningPrizeResult().getOrDefault(prize,0) + "개"
            );
        }
        System.out.printf("총 수익률은 %.2f 입니다.", + winningPrizeResult.getRateOfReturn());
    }
}
