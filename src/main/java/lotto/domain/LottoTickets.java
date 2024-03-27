package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public WinningResult winningCheck(LottoTicket winningTicket) {
        Map<Integer, Integer> result = new HashMap<>();
        for (LottoTicket ticket : tickets) {
            int count = ticket.winningCount(winningTicket);
            result.put(count, result.getOrDefault(count, 0) + 1);
        }
        return new WinningResult(result, totalPrice());
    }

    private int totalPrice() {
        return tickets.size()*LottoMachine.LOTTO_PRICE;
    }
}
