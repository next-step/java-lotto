package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoRankingSystem;

import java.util.*;

public class LottoWinningStatistics {
    private final Map<LottoRankingSystem, Integer> values;

    public LottoWinningStatistics(List<Lotto> userLottos, Lotto winningLotto) {
        Map<LottoRankingSystem, Integer> result = initStatistics();

        for (Lotto userLotto : userLottos) {
            putRankedLottoQuantity(result, userLotto, winningLotto);
        }
        this.values = result;
    }

    private Map<LottoRankingSystem, Integer> initStatistics() {
        Map<LottoRankingSystem, Integer> statistics = new EnumMap<>(LottoRankingSystem.class);
        Arrays.stream(LottoRankingSystem.values())
                .forEach(value -> statistics.put(value, 0));
        return statistics;
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
        result.put(key, result.get(key) + 1);
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
        return this.values.get(ranking);
    }

    public static float calculateReturnRate(int lottoWinningAmount, int lottoPurchaseAmount) {
        return lottoWinningAmount / (float) lottoPurchaseAmount;
    }
}
