package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoStatistics {

    private final Map<LottoRank, Integer> matchCounts;
    private final int totalPurchaseAmount;

    public LottoStatistics(WinningNumbers winningTicket, List<LottoTicket> purchaseTickets) {
        this.matchCounts = calculateRankCounts(winningTicket, purchaseTickets);
        this.totalPurchaseAmount = purchaseTickets.size() * LottoOrder.PRICE_PER_TICKET;
    }

    private Map<LottoRank, Integer> calculateRankCounts(WinningNumbers winningTicket, List<LottoTicket> purchaseTickets) {
        Map<LottoRank, Integer> counts = new EnumMap<>(LottoRank.class);
        for (LottoTicket ticket : purchaseTickets) {
            LottoRank rank = winningTicket.getLottoRank(ticket);
            if (rank != null) {
                counts.put(rank, counts.getOrDefault(rank, 0) + 1);
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
