package lotto.domain.reward;

import static lotto.config.LottoExceptionMessage.LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE;
import static lotto.config.LottoExceptionMessage.LOTTO_TOTAL_PRICE_MUST_BE_BIGGER_THAN_UNIT_PRICE;
import static lotto.config.LottoExceptionMessage.LOTTO_TOTAL_PRICE_MUST_BE_MULTIPLE_OF_UNIT_PRICE;

import java.util.Map;

public class LottoCalculator {

    static final int LOTTO_PRICE_PER_UNIT = 1000;
    private static final double FLOOR_STANDARD = 100.0;

    public int calculateQuantity(final int totalPrice) {
        validateTotalPriceIsBiggerThanUnitPrice(totalPrice);
        validateTotalPriceIsMultipleOfUniPrice(totalPrice);

        return totalPrice / LOTTO_PRICE_PER_UNIT;
    }

    private void validateTotalPriceIsBiggerThanUnitPrice(final int totalPrice) {
        if (totalPrice < LOTTO_PRICE_PER_UNIT) {
            throw new IllegalArgumentException(LOTTO_TOTAL_PRICE_MUST_BE_BIGGER_THAN_UNIT_PRICE.message(totalPrice));
        }
    }

    private void validateTotalPriceIsMultipleOfUniPrice(final int totalPrice) {
        if (totalPrice % LOTTO_PRICE_PER_UNIT != 0) {
            throw new IllegalArgumentException(LOTTO_TOTAL_PRICE_MUST_BE_MULTIPLE_OF_UNIT_PRICE.message(totalPrice));
        }
    }

    public double calculateProfitRate(final Map<LottoRank, Long> lottoResult, final int totalPrice) {
        validateLottoResultMatchesTotalPrice(lottoResult, totalPrice);

        return floor(profitRate(lottoResult, totalPrice));
    }

    private double profitRate(final Map<LottoRank, Long> lottoResult, final int totalPrice) {
        final long totalProfit = lottoResult.keySet()
                .stream()
                .mapToLong(rank -> rank.rewardAmount() * lottoResult.get(rank))
                .sum();

        return (double)totalProfit / totalPrice;
    }

    private double floor(final double rate) {
        return Math.floor(rate * FLOOR_STANDARD) / FLOOR_STANDARD;
    }

    private void validateLottoResultMatchesTotalPrice(final Map<LottoRank, Long> lottoResult, final int totalPrice) {
        final long lottoQuantity = lottoResult.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();

        if (lottoQuantity != calculateQuantity(totalPrice)) {
            throw new IllegalArgumentException(LOTTO_RESULT_DOES_NOT_MATCH_TOTAL_PRICE.message());
        }
    }
}
