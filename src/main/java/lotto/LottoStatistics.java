package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<Integer, Integer> matchCounts;
    private final int totalPurchaseAmount;

    public LottoStatistics(LottoTicket winningTicket, LottoTicket[] purchaseTickets) {
        this.matchCounts = calculateMatchCounts(winningTicket, purchaseTickets);
        this.totalPurchaseAmount = purchaseTickets.length * LottoTicket.PRICE_PER_TICKET;
    }

    private Map<Integer, Integer> calculateMatchCounts(LottoTicket winningTicket, LottoTicket[] purchaseTickets) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (LottoTicket ticket : purchaseTickets) {
            int matches = winningTicket.countMatches(ticket);
            counts.put(matches, counts.getOrDefault(matches, 0) + 1);
        }
        return counts;
    }

    public int getCountByMatches(int matches) {
        return matchCounts.getOrDefault(matches, 0);
    }

    private int calculateTotalWinningAmount() {
        return LottoPrize.calculateTotalWinningAmount(matchCounts);
    }

    public double calculateProfitRate() {
        int totalWinningAmount = calculateTotalWinningAmount();
        return (double) totalWinningAmount / totalPurchaseAmount;
    }
}
