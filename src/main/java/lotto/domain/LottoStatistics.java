package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoStatistics {

    private final Map<LottoRank, Integer> matchCounts;
    private final Price totalPurchaseAmount;

    public LottoStatistics(WinningNumbers winningTicket, LottoTickets purchaseTickets) {
        this.matchCounts = calculateRankCounts(winningTicket, purchaseTickets.getTickets());
        this.totalPurchaseAmount = purchaseTickets.getTotalPrice();
    }

    private Map<LottoRank, Integer> calculateRankCounts(WinningNumbers winningTicket, List<LottoTicket> purchaseTickets) {
        Map<LottoRank, Integer> counts = new EnumMap<>(LottoRank.class);
        for (LottoTicket ticket : purchaseTickets) {
            LottoRank rank = winningTicket.getLottoRank(ticket);
            counts.put(rank, counts.getOrDefault(rank, 0) + 1);
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
        return totalPurchaseAmount.calculateYield(totalWinningAmount);
    }
}
