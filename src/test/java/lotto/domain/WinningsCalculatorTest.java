package lotto.domain;

import lotto.domain.LottoResult;
import lotto.domain.WinningsCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningsCalculatorTest {
    @Test
    void 등수에_따라_당첨금을_계산() {
        assertThat(WinningsCalculator.calculateWinnings(Arrays.asList(
                LottoResult.FIRST_PRIZE,
                LottoResult.SECOND_PRIZE,
                LottoResult.THIRD_PRIZE,
                LottoResult.THIRD_PRIZE))).isEqualTo(2000000000 + 1500000 + 50000 + 50000);
    }

    @Test
    void 투입된_금액대비_수익률_계산() {
        assertThat(WinningsCalculator.calculateYield(1000, 5000)).isEqualTo(5);
        assertThat(WinningsCalculator.calculateYield(14000, 5000)).isEqualTo((double) 5000 / 14000);
    }
}
