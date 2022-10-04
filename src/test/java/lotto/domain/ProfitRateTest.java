package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitRateTest {

    @DisplayName("로또 구매 금액과 상금의 대한 비율을 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,5000,5.00", "14000,5000,0.36", "20000,0,0.00"})
    void rate(final String purchase, final BigDecimal totalPrice, final String rate) {

        final ProfitRate profitRate = ProfitRate.of(totalPrice, Purchase.from(purchase));

        assertThat(profitRate.getProfitRate()).isEqualTo(rate);
    }
}