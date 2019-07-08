package lotto.domain.winning;

import lotto.common.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class EarningRateTest {

    @Test
    @DisplayName("수익률이 2배인경우를 확인한다")
    void checkEarningRate() {
        EarningRate earningRate = EarningRate.of(PositiveNumber.of(2000), PositiveNumber.of(1));
        assertThat(earningRate.get()).isEqualTo(2.0);
    }

    @Test
    @DisplayName("수익률이 0.5배인경우를 확인한다")
    void checkEarningRate2() {
        EarningRate earningRate = EarningRate.of(PositiveNumber.of(500), PositiveNumber.of(1));
        assertThat(earningRate.get()).isEqualTo(0.5);
    }
}
