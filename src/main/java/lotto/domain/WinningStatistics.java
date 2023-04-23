package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private final Map<LottoReward, Integer> accumulatedCountByLottoReward = new EnumMap<>(LottoReward.class);
    private final List<Integer> winningNumbers;
    private final List<List<Integer>> purchasedLottoTickets;

    public WinningStatistics(List<Integer> winningNumbers, List<List<Integer>> purchasedLottoTickets) {
        this.winningNumbers = winningNumbers;
        this.purchasedLottoTickets = purchasedLottoTickets;
    }

    public void calculate() {
        for (List<Integer> lottoTicket : purchasedLottoTickets) {
            long matchedCount = getMatchedCount(lottoTicket);
            accumulateCount(matchedCount);
        }
    }

    private long getMatchedCount(List<Integer> lottoTicket) {
        return lottoTicket.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void accumulateCount(long matchedCount) {
        if (matchedCount < 3) {
            return;
        }
        LottoReward lottoReward = LottoReward.findLottoReward(matchedCount);
        addAccumulatedCount(lottoReward);
    }

    private void addAccumulatedCount(LottoReward lottoReward) {
        Integer accumulatedCount = accumulatedCountByLottoReward.getOrDefault(lottoReward, 0) + 1;
        accumulatedCountByLottoReward.put(lottoReward, accumulatedCount);
    }

    public Map<LottoReward, Integer> getDetail() {
        return accumulatedCountByLottoReward;
    }

    public double getIncomeRate() {
        long purchasedAmount = purchasedLottoTickets.size() * 1_000L;
        long rewardAmount = accumulatedCountByLottoReward.entrySet()
                .stream()
                .mapToLong(e -> e.getKey().getReward() * e.getValue())
                .sum();
        double incomeRate = (double) rewardAmount / purchasedAmount;
        return Double.parseDouble(String.format("%.2f", incomeRate));
    }
}