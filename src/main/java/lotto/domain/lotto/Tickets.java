package lotto.domain.lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tickets {

    private final List<Ticket> tickets;

    public Tickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int count() {
        return tickets.size();
    }

    public List<Numbers> getEachTicketNumbers() {
        return tickets.stream()
            .map(Ticket::getNumbers)
            .collect(Collectors.toList());
    }

    public Map<Rank, Integer> getComparisonPrizeMap(Numbers answerNumbers, int bonus) {
        Map<Rank, Integer> prizeMap = new LinkedHashMap<>();
        for (Ticket ticket : tickets) {
            int matches = ticket.matches(answerNumbers.get());
            Rank rank = Rank.getRank(matches, ticket.hasBonus(bonus));

            prizeMap.put(rank, prizeMap.getOrDefault(rank, 0) + 1);
        }

        return prizeMap;
    }
}
