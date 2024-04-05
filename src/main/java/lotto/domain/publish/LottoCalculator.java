package lotto.domain.publish;

public class LottoCalculator {

    public static final int LOTTO_PRICE_PER_UNIT = 1000;

    public int calculateAutoQuantity(final int totalPrice, final int manualCount) {
        validateTotalPriceIsBiggerThanUnitPrice(totalPrice);
        validateTotalPriceIsMultipleOfUniPrice(totalPrice);

        final int totalCount = totalPrice / LOTTO_PRICE_PER_UNIT;
        validateManualCountNotExceedTotalCount(manualCount, totalCount);

        return totalCount - manualCount;
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

    private void validateManualCountNotExceedTotalCount(final int manualCount, final int totalCount) {
        if (manualCount > totalCount) {
            throw new IllegalArgumentException("수동 구매 개수는 총 구매 개수보다 많을 수 없습니다.");
        }
    }
}
