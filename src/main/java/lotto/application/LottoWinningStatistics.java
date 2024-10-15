package lotto.application;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRankingSystem;

import java.util.*;

public class LottoWinningStatistics {
    private final Map<LottoRankingSystem, Integer> values;

    public LottoWinningStatistics(List<LottoNumbers> userLottoTicket, LottoNumbers winningLottoNumbers) {
        Map<LottoRankingSystem, Integer> result = new EnumMap<>(LottoRankingSystem.class);

        for (LottoNumbers userLottoNumbers : userLottoTicket) {
            putRankedLottoNumbersQuantity(result, userLottoNumbers, winningLottoNumbers);
        }
        this.values = result;
    }

    public LottoWinningStatistics(Map<LottoRankingSystem, Integer> values) {
        this.values = values;
    }

    private void putRankedLottoNumbersQuantity(Map<LottoRankingSystem, Integer> result,
                                                                           LottoNumbers userLottoNumbers,
                                                                           LottoNumbers winningLottoNumbers) {
        int matchingCount = winningLottoNumbers.countMatchingNumbers(userLottoNumbers);
        if (checkNonRanked(matchingCount)) {
            return;
        }
        LottoRankingSystem key = LottoRankingSystem.from(matchingCount);
        result.put(key, result.getOrDefault(key, 0) + 1);
    }

    private static boolean checkNonRanked(int matchingCount) {
        return LottoRankingSystem.isNotRankEligible(matchingCount);
    }

    public int calculateWinningAmount() {
        int winningAmount = 0;
        for (Map.Entry<LottoRankingSystem, Integer> result : this.values.entrySet()) {
            winningAmount += result.getKey().getDistributionRatioPrice() * result.getValue();
        }
        return winningAmount;
    }

    public Integer getLottoQuantityOfRanking(LottoRankingSystem ranking) {
        return Objects.isNull(this.values.get(ranking)) ? 0 : this.values.get(ranking);
    }

}
