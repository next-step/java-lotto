package lotto.domain;

import java.util.Map;

public class WinningStatistics {

    private final Map<LottoReward, Integer> accumulatedCountByLottoReward = LottoReward.makeCountMap();
    private final LottoWinningNumber lottoWinningNumber;
    private final LottoTickets lottoTickets;

    public WinningStatistics(LottoWinningNumber lottoWinningNumber, LottoTickets lottoTickets) {
        this.lottoWinningNumber = lottoWinningNumber;
        this.lottoTickets = lottoTickets;
    }

    public void calculate() {
        for (LottoNumbers lottoNumbers : lottoTickets.getTickets()) {
            long matchedCount = lottoNumbers.matchCount(lottoWinningNumber);
            accumulateCount(matchedCount);
        }
        accumulatedCountByLottoReward.remove(LottoReward.NONE);
    }

    private void accumulateCount(long matchedCount) {
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
        long purchasedAmount = lottoTickets.size() * 1_000L;
        long rewardAmount = accumulatedCountByLottoReward.entrySet()
                .stream()
                .mapToLong(e -> e.getKey().getReward() * e.getValue())
                .sum();
        double incomeRate = (double) rewardAmount / purchasedAmount;
        return Double.parseDouble(String.format("%.2f", incomeRate));
    }

}