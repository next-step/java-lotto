package lotto.domain.winning;

import lotto.domain.LottoRank;
import lotto.domain.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningTickets {
    private final Map<LottoRank, List<LottoTicket>> winningTickets;

    public WinningTickets(Map<LottoRank, List<LottoTicket>> winningTickets) {
        this.winningTickets = new HashMap<>(winningTickets);
    }

    public int getWinningTicketCount(LottoRank lottoRank) {
        return winningTickets.getOrDefault(lottoRank, new ArrayList<>()).size();
    }

    public long getWinningPrice() {
        return winningTickets.keySet().stream()
                             .mapToLong(LottoRank::getWinningPrice)
                             .sum();
    }
}
