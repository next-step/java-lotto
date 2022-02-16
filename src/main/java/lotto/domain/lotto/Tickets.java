package lotto.domain.lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tickets {

    private static final int MAP_DEFAULT = 0;

    private final List<Ticket> tickets;

    public Tickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getEachTicketNumbers() {
        return tickets;
    }

    public Map<Rank, Integer> getComparisonPrizeMap(final Ticket answerNumbers, final Number bonus) {
        Map<Rank, Integer> prizeMap = new LinkedHashMap<>();
        for (Ticket ticket : tickets) {
            int matches = ticket.matches(answerNumbers);
            Rank rank = Rank.getRank(matches, ticket.hasBonus(bonus));

            prizeMap.put(rank, prizeMap.getOrDefault(rank, MAP_DEFAULT) + 1);
        }

        return prizeMap;
    }
}
