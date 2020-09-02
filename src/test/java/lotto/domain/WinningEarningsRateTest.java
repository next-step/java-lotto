package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningEarningsRateTest {
    WinningEarningsRate winningEarningsRate;

    @BeforeEach
    void createWinningEarningsRate() {
        winningEarningsRate = new WinningEarningsRate(14000);
    }

    @Test
    void createValue() {
        Assertions.assertThat(winningEarningsRate).isEqualToComparingFieldByField(new WinningEarningsRate(14000));
    }

    @Test
    void calculationEarningsRate() {
        Assertions.assertThat(winningEarningsRate.calculationEarningsRate(5000)).isEqualTo(0.35);
    }
}