package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MatchResult {
    private static final Map<Integer, Integer> matchPriceInfo;

    static {
        matchPriceInfo = new HashMap<>();
        matchPriceInfo.put(3, 5_000);
        matchPriceInfo.put(4, 50_000);
        matchPriceInfo.put(5, 1_500_000);
        matchPriceInfo.put(6, 2_000_000_000);
    }

    private TreeMap<Integer, Integer> matchCounts;
    private int ticketCount;

    public MatchResult(Map<Integer, Integer> matchCounts) {
        this.matchCounts = matchPriceInfo.keySet().stream()
              .collect(Collectors.toMap(Function.identity(), matchCount -> matchCounts
                    .getOrDefault(matchCount, 0), Integer::sum, TreeMap::new));

        this.ticketCount = matchCounts.values().stream()
              .reduce(Integer::sum).orElse(0);
    }

    public BigDecimal calculateProfit() {
        double totalPrice = this.matchCounts.keySet().stream()
              .mapToDouble(matchCount -> priceMoney(matchCount) * matchTickets(matchCount))
              .sum();

        return new BigDecimal(totalPrice / sumOfTicketPrice(this.ticketCount));
    }

    private int sumOfTicketPrice(int ticketCount) {
        return ticketCount * LottoTickets.TICKET_PRICE;
    }

    private int priceMoney(int matchCount) {
        return matchPriceInfo.get(matchCount);
    }

    private int matchTickets(int matchCount) {
        return this.matchCounts.getOrDefault(matchCount, 0);
    }

    public static int getMatchPrice(int matchCount) {
        return matchPriceInfo.getOrDefault(matchCount, 0);
    }

    public TreeMap<Integer, Integer> getMatchCounts() {
        return matchCounts;
    }

    public int getTicketCount() {
        return ticketCount;
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
        return Objects.equals(matchCounts, that.matchCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCounts);
    }
}
