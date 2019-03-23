package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningRateTest {
    //TODO : 수익률 계산 ( 구매비용, 당첨금 ) -> 수익률

    @Test
    public void 수익률계산() {
        EarningRate earningRate = new EarningRate(5_000, 5_000);
        assertThat(earningRate.toString()).isEqualTo("1.00");
    }

    @Test
    public void 소수점_수익률_계산() {
        EarningRate earningRate = new EarningRate(10_300, 5_000);
        assertThat(earningRate.toString()).isEqualTo("0.49");
    }
}
