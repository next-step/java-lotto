package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private static final int TICKET_PRICE = 1000;

    private final List<LottoTicket> tickets;

    public LottoTickets(int count) {
        this.tickets = issueTickets(count);
    }

    public LottoTickets(PurchaseAmount amount) {
        this.tickets = issueTickets(amount.getTicketCount(TICKET_PRICE));
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    private List<LottoTicket> issueTickets(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public int getCount() {
        return tickets.size();
    }

    public Map<LottoRank, Integer> getRankStatistics(LottoTicket winningTicket) {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);

        Arrays.stream(LottoRank.values())
                .forEach(rank -> statistics.put(rank, 0));

        tickets.stream()
                .map(ticket -> ticket.rank(winningTicket))
                .forEach(rank -> statistics.merge(rank, 1, Integer::sum));

        return statistics;
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

    public double cost() {
        return Math.multiplyExact(TICKET_PRICE, tickets.size());
    }
}
