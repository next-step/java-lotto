package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult(LottoTickets tickets, WinningNumbers winningNumbers) {
        this.result = calculateResult(tickets, winningNumbers);
    }

    private Map<Rank, Integer> calculateResult(LottoTickets tickets, WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = initializeResult();
        List<Lotto> lottos = tickets.getLottos();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningNumbers);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private Map<Rank, Integer> initializeResult() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    public int getCountByRank(Rank rank) {
        return result.get(rank);
    }

    public int getTotalWinningAmount() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += rank.getWinningAmount() * result.get(rank);
        }
        return total;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculateProfitRate(getTotalWinningAmount());
    }
}
