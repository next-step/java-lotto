package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult(LottoTickets tickets, Lotto winningNumbers) {
        this.result = new HashMap<>();
        initializeResult();
        calculateResult(tickets, winningNumbers);
    }

    private void initializeResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    private void calculateResult(LottoTickets tickets, Lotto winningNumbers) {
        List<Lotto> lottos = tickets.getLottos();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchNumber(winningNumbers);
            Rank rank = Rank.valueOf(matchCount);
            result.put(rank, result.get(rank) + 1);
        }
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

    public double calculateProfitRate(int purchaseAmount) {
        return (double) getTotalWinningAmount() / purchaseAmount;
    }
}
