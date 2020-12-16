package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class MatchResult {

    private Map<MatchCount, Integer> matchCounts;
    private int ticketCount;

    public MatchResult(Map<MatchCount, Integer> matchCounts) {
        this.matchCounts = MatchCount.result(matchCounts);
        this.ticketCount = matchCounts.values().stream()
              .reduce(Integer::sum).orElse(0);
    }

    MatchResult(Map<MatchCount, Integer> matchCounts, int ticketCount) {
        this.matchCounts = matchCounts;
        this.ticketCount = ticketCount;
    }

    public BigDecimal calculateProfit() {
        double totalPrice = this.matchCounts.keySet().stream()
              .mapToDouble(
                    matchCount -> MatchCount.priceMoney(matchCount) * matchTickets(matchCount))
              .sum();

        return new BigDecimal(totalPrice / sumOfTicketPrice(this.ticketCount));
    }

    private int sumOfTicketPrice(int ticketCount) {
        return ticketCount * LottoTickets.TICKET_PRICE;
    }

    private int matchTickets(MatchCount matchCount) {
        return this.matchCounts.getOrDefault(matchCount, 0);
    }

    public Map<MatchCount, Integer> getMatchCounts() {
        return matchCounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchResult that = (MatchResult) o;
        return ticketCount == that.ticketCount &&
              Objects.equals(matchCounts, that.matchCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCounts, ticketCount);
    }
}
