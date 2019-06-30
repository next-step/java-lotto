package lotto.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class EarningRateTest {

    @Test
    @DisplayName("당첨금액이 0원인경우 예외처리를 확인한다")
    void checkException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    EarningRate.of(0, 1000);
                }).withMessageMatching("Amount must grather than 0");
    }

    @Test
    @DisplayName("구입금액이 0원인경우 예외처리를 확인한다")
    void checkException2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    EarningRate.of(1000, 0);
                }).withMessageMatching("Amount must grather than 0");
    }

    @Test
    @DisplayName("수익률이 2배인경우를 확인한다")
    void checkEarningRate() {
        EarningRate earningRate = EarningRate.of(1000, 500);
        assertThat(earningRate.get()).isEqualTo(2.0);
    }

    @Test
    @DisplayName("수익률이 0.5배인경우를 확인한다")
    void checkEarningRate2() {
        EarningRate earningRate = EarningRate.of(500, 1000);
        assertThat(earningRate.get()).isEqualTo(0.5);
    }
}
