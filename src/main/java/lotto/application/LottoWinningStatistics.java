package lotto.application;

import lotto.domain.*;

import java.util.*;

public class LottoWinningStatistics {
    private final Map<LottoRank, Integer> values;

    public LottoWinningStatistics(Lottos userLottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> result = initStatistics();

        for (int i = 0; i < userLottos.size(); i++) {
            this.putRankedLottoQuantity(winningLotto.createLottoRank(userLottos.valueAt(i)), result);
        }
        this.values = result;
    }

    private Map<LottoRank, Integer> initStatistics() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(value -> statistics.put(value, 0));
        return statistics;
    }

    public LottoWinningStatistics(Map<LottoRank, Integer> values) {
        this.values = values;
    }

    private void putRankedLottoQuantity(LottoRank key, Map<LottoRank, Integer> result) {
        result.put(key, result.get(key) + 1);
    }

    public float calculateReturnRate(LottoPrice lottoPurchaseAmount) {
        return Math.round((this.calculateWinningAmount() / lottoPurchaseAmount.value()) * 100) / 100.0f;
    }

    private int calculateWinningAmount() {
        int winningAmount = 0;
        for (Map.Entry<LottoRank, Integer> result : this.values.entrySet()) {
            winningAmount += result.getKey().getDistributionRatioPrice() * result.getValue();
        }
        return winningAmount;
    }

    public Integer getLottoQuantityOfRanking(LottoRank ranking) {
        return this.values.get(ranking);
    }
}
