package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoRankingSystem;

import java.util.*;

public class LottoWinningStatistics {
    private final Map<LottoRankingSystem, Integer> values;

    public LottoWinningStatistics(List<Lotto> userLottos, Lotto winningLotto) {
        Map<LottoRankingSystem, Integer> result = new EnumMap<>(LottoRankingSystem.class);

        for (Lotto userLotto : userLottos) {
            putRankedLottoQuantity(result, userLotto, winningLotto);
        }
        this.values = result;
    }

    public LottoWinningStatistics(Map<LottoRankingSystem, Integer> values) {
        this.values = values;
    }

    private void putRankedLottoQuantity(Map<LottoRankingSystem, Integer> result,
                                        Lotto userLotto,
                                        Lotto winningLotto) {
        int matchingCount = winningLotto.countMatchingNumbers(userLotto);
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

    public static float calculateReturnRate(int lottoWinningAmount, int lottoPurchaseAmount) {
        return lottoWinningAmount / (float) lottoPurchaseAmount;
    }
}
