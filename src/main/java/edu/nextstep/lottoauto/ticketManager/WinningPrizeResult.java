/*
 * WinningPrizeResult.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.ticket.Prize;
import edu.nextstep.lottoauto.ticket.Ticket;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningPrizeResult {

    private final Map<Prize, Integer> winningPrizeResult ;
    private final double rateOfReturn;

    private WinningPrizeResult(double rateOfReturn) {
        this.winningPrizeResult = new LinkedHashMap<>();
        this.rateOfReturn = rateOfReturn;
    }

    public static WinningPrizeResult of(List<Ticket> winningTickets, double rateOfReturn) {
        WinningPrizeResult winningPrizeResult = new WinningPrizeResult(rateOfReturn);
        for (Ticket winningTicket : winningTickets) {
            winningPrizeResult.add(winningTicket);
        }
        return winningPrizeResult;
    }

    private void add(Ticket ticket) {
        if (ticket.getPrize() != null) {
            winningPrizeResult.put(ticket.getPrize(),
                    winningPrizeResult.getOrDefault(ticket.getPrize(), 0) + 1);
        }
    }

    public Map<Prize, Integer> getWinningPrizeResult() {
        return winningPrizeResult;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
