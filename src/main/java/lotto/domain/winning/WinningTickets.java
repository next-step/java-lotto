package lotto.domain.winning;

import lotto.domain.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningTickets {
    private static final Map<Integer, Long> WINNING_PRICE = Map.of(
        3, 5000L,
        4, 50000L,
        5, 1500000L,
        6, 2000000000L
    );
    private final Map<Integer, List<LottoTicket>> winningTickets;

    public WinningTickets(Map<Integer, List<LottoTicket>> winningTickets) {
        this.winningTickets = new HashMap<>(winningTickets);
    }

    public int getWinningTicketCount(int winningRank) {
        return winningTickets.getOrDefault(winningRank, new ArrayList<>()).size();
    }

    public long getWinningPrice() {
        return winningTickets.entrySet()
                             .stream()
                             .filter(winningTicket -> WINNING_PRICE.containsKey(winningTicket.getKey()))
                             .mapToLong(winningTicket -> winningTicket.getValue()
                                                                      .size() * WINNING_PRICE.get(winningTicket.getKey()))
                             .sum();
    }
}
