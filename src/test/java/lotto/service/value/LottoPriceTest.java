package lotto.service.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPriceTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1000 |     1",
            "2000 |     2",
            "10000|    10",
            "15000|    15",
            "20000|    20",
    }, delimiter = '|')
    @DisplayName("수량 검증")
    void getQuantity(Integer purchasePrice, Integer quantity) {
        LottoPrice lottoPrice = LottoPrice.from(purchasePrice);
        assertThat(lottoPrice.getQuantity()).isEqualTo(quantity);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "14000|    5000|    0.35",
            "14000|   14000|       1",
            "14000|       0|       0",
            "14000|   28000|       2"
    }, delimiter = '|')
    @DisplayName("수익률 검증")
    void getYield(Integer purchasePrice, BigDecimal winningMoney, BigDecimal yield) {
        LottoPrice lottoPrice = LottoPrice.from(purchasePrice);
        assertThat(lottoPrice.getYield(winningMoney)).isEqualByComparingTo(yield);
    }
}
