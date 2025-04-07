package lotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoStatistics {

    private final Map<LottoRank, Integer> matchCounts;
    private final int totalPurchaseAmount;

    public LottoStatistics(LottoTicket winningTicket, LottoTicket[] purchaseTickets) {
        this.matchCounts = calculateRankCounts(winningTicket, purchaseTickets);
        this.totalPurchaseAmount = purchaseTickets.length * LottoTicket.PRICE_PER_TICKET;
    }

    private Map<LottoRank, Integer> calculateRankCounts(LottoTicket winningTicket, LottoTicket[] purchaseTickets) {
        Map<LottoRank, Integer> counts = new EnumMap<>(LottoRank.class);
        for (LottoTicket ticket : purchaseTickets) {
            int matches = winningTicket.countMatches(ticket);
            boolean containsBonusNumber = ticket.containsBonusNumber(winningTicket);
            LottoRank rank = LottoRank.getRank(matches, containsBonusNumber);
            if (rank != null) {
                counts.put(rank, counts.getOrDefault(matches, 0) + 1);
            }
        }
        return counts;
    }

    public int getCountByRank(LottoRank lottoRank) {
        return matchCounts.getOrDefault(lottoRank, 0);
    }

    public int calculateTotalWinningAmount() {
        int totalAmount = 0;
        for (Entry<LottoRank, Integer> entry : matchCounts.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalAmount += rank.getPrizeMoney(count);
        }
        return totalAmount;
    }

    public double calculateProfitRate() {
        int totalWinningAmount = calculateTotalWinningAmount();
        return (double) totalWinningAmount / totalPurchaseAmount;
    }
}
