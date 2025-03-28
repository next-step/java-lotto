package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(int count) {
        this.tickets = issueTickets(count);
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


}
