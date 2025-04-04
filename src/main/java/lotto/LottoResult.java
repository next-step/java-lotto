package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {

    private final LottoTicket winningTicket;
    private final LottoTicket[] purchaseTickets;

    public LottoResult(LottoTicket winningTicket, LottoTicket[] purchaseTickets) {
        this.winningTicket = winningTicket;
        this.purchaseTickets = purchaseTickets;
    }

    public static double calculateProfitRate(int purchaseAmount, int winningAmount) {
        return (double) winningAmount / purchaseAmount;
    }

    public Map<LottoPrize, Integer> calculateStatistics() {
        Map<LottoPrize, Integer> lottoPrizes = new HashMap<>();
        for (LottoTicket purchaseTicket : purchaseTickets) {
            int countMatches = winningTicket.countMatches(purchaseTicket);
            LottoPrize lottoPrize = LottoPrize.getPrize(countMatches);
            lottoPrizes.put(lottoPrize, lottoPrizes.getOrDefault(lottoPrize, 0) + 1);
        }
        return lottoPrizes;
    }

    public double calculateProfitRate() {
        Map<LottoPrize, Integer> lottoPrizeCountMap = calculateStatistics();
        int purchaseAmount = purchaseTickets.length * LottoTicket.PRICE_PER_TICKET;
        int winningAmount = 0;
        for (Entry<LottoPrize, Integer> entry : lottoPrizeCountMap.entrySet()) {
            winningAmount += entry.getKey().getPrize() * entry.getValue();
        }

        return (double) winningAmount / purchaseAmount;
    }
}
