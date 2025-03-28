package lotto.domain;

import java.util.*;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000;
    private final int amount;
    private final List<LottoTicket> tickets;

    public LottoMachine(int amount) {
        validatePositiveAmount(amount);
        validateDividedAmount(amount);
        this.amount = amount;
        this.tickets = new ArrayList<>();
    }

    public LottoMachine(int amount, List<LottoTicket> tickets) {
        validatePositiveAmount(amount);
        validateDividedAmount(amount);
        validateTicketSize(amount, tickets.size());
        this.amount = amount;
        this.tickets = new ArrayList<>(tickets);
    }

    public List<LottoTicket> issue() {
        if (!tickets.isEmpty())
            throw new UnsupportedOperationException("tickets already issued.");

        int ticketCount = amount / TICKET_PRICE;

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return Collections.unmodifiableList(tickets);
    }

    private void validateTicketSize(int amount, int size) {
        int ticketSize = amount / TICKET_PRICE;
        if (size != ticketSize)
            throw new IllegalArgumentException("ticket size and amount is mismatched");
    }

    private void validatePositiveAmount(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException(String.format("lotto machine can take %d per ticket. but you paid %d", TICKET_PRICE, amount));
    }

    private void validateDividedAmount(int amount) {
        if (amount % TICKET_PRICE != 0)
            throw new IllegalArgumentException(String.format("lotto machine can take %d per ticket. but you paid %d.", TICKET_PRICE, amount));
    }

    public Map<LottoRank, Integer> compare(LottoTicket winningTicket) {
        Map<LottoRank, Integer> stats = new EnumMap<>(LottoRank.class);

        Arrays.stream(LottoRank.values()).forEach(rank -> stats.put(rank, 0));

        for (LottoTicket ticket : tickets) {
            LottoRank rank = ticket.rank(winningTicket);
            stats.put(rank, stats.get(rank) + 1);
        }

        return stats;
    }

    public double calculateRevenue(LottoTicket winningTicket) {
        Map<LottoRank, Integer> stats = compare(winningTicket);

        int revenue = 0;
        for (LottoRank rank : stats.keySet()) {
            revenue += rank.getPrize() * stats.get(rank);
        }
        return (double) revenue / amount;
    }

}
