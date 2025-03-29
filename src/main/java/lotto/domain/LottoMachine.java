package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoMachine {

    private final LottoTickets tickets;

    public LottoMachine(PurchaseAmount amount) {
        this(new LottoTickets(amount));
    }

    public LottoMachine(LottoTickets tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return tickets.getTickets();
    }

    public Map<LottoRank, Integer> getRankStatistics(LottoTicket winningTicket) {
        return tickets.getRankStatistics(winningTicket);
    }

    public double getReturnRate(LottoTicket winningTicket) {
        return tickets.getReturnRate(winningTicket);
    }

}
