package lotto.domain;

import java.util.Map;

import static lotto.LottoApplication.LOTTO_COST;

public class Profit {

    private final double profitRate;

    public Profit(Results results, Lottos lottos) {
        this.profitRate = calculateProfitRate(results, lottos);
    }

    public double getProfitRate() {
        return profitRate;
    }

    private double calculateProfitRate(Results results, Lottos lottos) {
        // 수익률을 계산한다.
        int totalReward = results.of().entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();

        for (int value : results.of().values()) {
            totalReward += value;
        }
        double profitRate = (double) totalReward / (lottos.of().size() * LOTTO_COST);

        return  Math.round(profitRate * 100) / 100.0;
    }
}
