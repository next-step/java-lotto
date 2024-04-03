package lotto.domain.publish;

import static lotto.domain.publish.LottoCalculator.LOTTO_PRICE_PER_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,1", "5000,3", "10000,2", "50000,0", "100000,10"})
    @DisplayName("총 로또 구매 가격에 따라 자동 로또 구매 개수를 반환한다.")
    void CalculateAutoQuantity(final int totalPrice, final int manualCount) {
        final int expectedQuantity = (totalPrice / LOTTO_PRICE_PER_UNIT) - manualCount;

        assertThat(new LottoCalculator().calculateAutoQuantity(totalPrice, manualCount))
                .isEqualTo(expectedQuantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, LOTTO_PRICE_PER_UNIT - 1})
    @DisplayName("총 로또 구매 가격이 로또 1개 당 가격보다 적은 경우 예외를 던진다.")
    void CalculateAutoQuantity_TotalPriceLessThanUnitPrice_Exception(final int priceLessThanUnitPrice) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateAutoQuantity(priceLessThanUnitPrice, 0));
    }

    @Test
    @DisplayName("총 로또 구매 가격이 로또 1개 당 가격의 배수가 아닌 경우 예외를 던진다.")
    void CalculateAutoQuantity_TotalPriceNotMultipleOfUnitPrice_Exception() {
        final int priceNotMultipleOfUnitPrice = LOTTO_PRICE_PER_UNIT * 2 + 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateAutoQuantity(priceNotMultipleOfUnitPrice, 0));
    }

    @Test
    @DisplayName("수동 구매 수가 총 구매 수보다 많은 경우 예외를 던진다.")
    void CalculateAutoQuantity_ManualCountExceedTotalCount_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateAutoQuantity(LOTTO_PRICE_PER_UNIT, 2));
    }
}
