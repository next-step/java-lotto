/*
 * WinningPrizeResult.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.ticket.Prize;
import edu.nextstep.lottoauto.ticket.Ticket;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningPrizeResult {

    private final Map<Prize, Integer> winningPrizeResult = new LinkedHashMap<>();

    public Map<Prize, Integer> getWinningPrizeResult() {
        return winningPrizeResult;
    }

    public void add(Ticket ticket) {
        winningPrizeResult.put(ticket.getPrize(),
                winningPrizeResult.getOrDefault(ticket.getPrize(), 0) + 1);
    }
}
