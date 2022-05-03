package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class EarningRateTest {
    private static final long HUNDRED_THOUSAND = 100000;
    private static final long THOUSAND = 1000;

    @Test
    void earningRate는_상금_금액과_구매_비용으로_생성_가능하다() {
        Amount purchaseAmount = new Amount(HUNDRED_THOUSAND);
        Amount prizeAmount = new Amount(THOUSAND);

        assertThat(EarningRate.of(purchaseAmount, prizeAmount).getValue())
                .isEqualTo((double) HUNDRED_THOUSAND / THOUSAND);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "1.1:true", "0.9:false"}, delimiter = ':')
    void isProfit은_이득_여부를_반환한다(double earningRate, boolean isProfit) {
        assertThat(new EarningRate(earningRate).isProfit())
                .isEqualTo(isProfit);
    }
}
