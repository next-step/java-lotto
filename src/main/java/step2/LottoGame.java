package step2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private static final int PRICE = 1_000;
    private final int ticketCount;
    private final List<LottoTicket> lottoTickets;
    private final Map<MatchCount, Long> results;

    public LottoGame(Money money) {
        results = initializeResults();
        ticketCount = money.getAffordableTicketCount(PRICE);
        lottoTickets = generateAutoLottoTickets(ticketCount);
    }

    private Map<MatchCount, Long> initializeResults() {
        final Map<MatchCount, Long> results = new LinkedHashMap<>();
        Arrays.stream(MatchCount.values())
                .sorted(Comparator.comparing(MatchCount::getMatchCount))
                .forEach(matchCount -> results.putIfAbsent(matchCount, 0L));
        return results;
    }

    private List<LottoTicket> generateAutoLottoTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(e -> new AutoLottoTicket())
                .collect(Collectors.toList());
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }

    public void findWinningResult(YourLottoTicket yourLottoTicket) {
        lottoTickets.stream()
                .map(lottoTicket -> countMatch(yourLottoTicket, lottoTicket.sixNumbers))
                .map(MatchCount::of)
                .forEach(matchCount -> results.put(matchCount, results.get(matchCount) + 1L));
    }

    private int countMatch(YourLottoTicket yourLottoTicket, List<Integer> sixNumbers) {
        return (int) yourLottoTicket.sixNumbers.stream()
                .filter(sixNumbers::contains)
                .count();
    }

    public Map<MatchCount, Long> getResults() {
        return new LinkedHashMap<>(results);
    }

    public Double getProfitRate() {
        return (double) results.entrySet()
                .stream()
                .mapToInt(e -> e.getValue().intValue() * e.getKey().getPrize())
                .sum() / getTotalTakenMoneyAmount();
    }

    private int getTotalTakenMoneyAmount() {
        return ticketCount * PRICE;
    }
}
