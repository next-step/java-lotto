package lotto.domain.reward;

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
            throw new IllegalArgumentException("총 로또 구매 가격은 1개 당 가격보다 커야합니다. 가격: " + totalPrice);
        }
    }

    private void validateTotalPriceIsMultipleOfUniPrice(final int totalPrice) {
        if (totalPrice % LOTTO_PRICE_PER_UNIT != 0) {
            throw new IllegalArgumentException("총 로또 구매 가격은 1개 당 가격의 배수여야 합니다. 가격: " + totalPrice);
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
            throw new IllegalArgumentException("당첨 결과 로또의 개수와 실제 구매 로또의 개수가 일치하지 않습니다.");
        }
    }
}
