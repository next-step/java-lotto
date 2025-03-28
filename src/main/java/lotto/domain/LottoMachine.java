package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000;
    private final LottoTickets tickets;

    public LottoMachine(PurchaseAmount amount) {
        this(new LottoTickets(amount.getTicketCount(TICKET_PRICE)));
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
        return (double) income(winningTicket) / cost();
    }

    private int income(LottoTicket winningTicket) {
        return getRankStatistics(winningTicket)
                .entrySet().stream()
                .map(entry -> entry.getKey().getTotalPrize(entry.getValue()))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private double cost() {
        return Math.multiplyExact(TICKET_PRICE, tickets.getCount());
    }

}
