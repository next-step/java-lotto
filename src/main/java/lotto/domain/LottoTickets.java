package lotto.domain;

import java.util.*;

public class LottoTickets {


    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
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

    public int income(LottoTicket winningTicket) {
        return getRankStatistics(winningTicket)
                .entrySet().stream()
                .map(entry -> entry.getKey().getTotalPrize(entry.getValue()))
                .reduce(Integer::sum)
                .orElse(0);
    }

}
