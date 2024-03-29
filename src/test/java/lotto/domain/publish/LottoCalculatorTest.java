package lotto.domain.publish;

import static lotto.domain.publish.LottoCalculator.LOTTO_PRICE_PER_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000, 50000, 100000})
    @DisplayName("총 로또 구매 가격에 따라 로또 구매 개수를 반환한다.")
    void CalculateQuantity(final int totalPrice) {
        assertThat(new LottoCalculator().calculateQuantity(totalPrice))
                .isEqualTo(totalPrice / LOTTO_PRICE_PER_UNIT);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, LOTTO_PRICE_PER_UNIT - 1})
    @DisplayName("총 로또 구매 가격이 로또 1개 당 가격보다 적은 경우 예외를 던진다.")
    void CalculateQuantity_TotalPriceLessThanUnitPrice_Exception(final int priceLessThanUnitPrice) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateQuantity(priceLessThanUnitPrice));
    }

    @Test
    @DisplayName("총 로또 구매 가격이 로또 1개 당 가격의 배수가 아닌 경우 예외를 던진다.")
    void CalculateQuantity_TotalPriceNotMultipleOfUnitPrice_Exception() {
        final int priceNotMultipleOfUnitPrice = LOTTO_PRICE_PER_UNIT * 2 + 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCalculator().calculateQuantity(priceNotMultipleOfUnitPrice));
    }
}
