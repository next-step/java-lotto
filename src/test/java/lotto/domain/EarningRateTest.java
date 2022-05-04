package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class EarningRateTest {
    @ParameterizedTest
    @CsvSource(value = {"1:false", "1.1:true", "0.9:false"}, delimiter = ':')
    void isProfit은_이득_여부를_반환한다(double earningRate, boolean isProfit) {
        assertThat(new EarningRate(earningRate).isProfit())
                .isEqualTo(isProfit);
    }
}
