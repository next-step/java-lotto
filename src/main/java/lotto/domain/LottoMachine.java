package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoMachine {

    private final LottoTickets tickets;
    private final PurchaseAmount amount;

    public LottoMachine(PurchaseAmount amount) {
        this(amount, new LottoTickets(amount.getTicketCount()));
    }

    public LottoMachine(PurchaseAmount amount, LottoTickets tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return tickets.getTickets();
    }

    public Map<LottoRank, Integer> getRankStatistics(LottoTicket winningTicket) {
        return tickets.getRankStatistics(winningTicket);
    }

    public double getReturnRate(LottoTicket winningTicket) {
        return amount.getReturnRate(income(winningTicket));
    }

    private int income(LottoTicket winningTicket) {
        return getRankStatistics(winningTicket)
                .entrySet().stream()
                .map(entry -> entry.getKey().getTotalPrize(entry.getValue()))
                .reduce(Integer::sum)
                .orElse(0);
    }

}
