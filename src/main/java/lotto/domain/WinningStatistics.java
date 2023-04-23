package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private final Map<LottoReward, Integer> accumulatedCountByLottoReward = new EnumMap<>(LottoReward.class);
    private final List<Integer> winningNumbers;

    public WinningStatistics(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void calculate(List<List<Integer>> purchasedLottoTickets) {
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
}