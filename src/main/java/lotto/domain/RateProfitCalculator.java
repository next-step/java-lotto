package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE;

import java.util.Map;

public class RateProfitCalculator {

    public double calculate(final Map<LottoRank, Long> lottoResult, final int totalPrice) {
        final long lottoQuantity = lottoResult.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        if (lottoQuantity != totalPrice / 1000) {
            throw new IllegalArgumentException(LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE.message());
        }

        long totalReward = lottoResult.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().rewardAmount() * entry.getValue())
                .sum();

        double rate = (double)totalReward / totalPrice;

        return Math.floor(rate * 100) / 100.0;
    }
}
