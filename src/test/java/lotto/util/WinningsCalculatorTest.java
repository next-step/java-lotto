package lotto.util;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningsCalculatorTest {
    @Test
    void 등수에_따라_당첨금을_계산() {
        assertThat(WinningsCalculator.calculateWinnings(Arrays.asList(
                LottoResult.FirstPrize,
                LottoResult.SecondPrize,
                LottoResult.ThirdPrize,
                LottoResult.ThirdPrize))).isEqualTo(2000000000 + 1500000 + 50000 + 50000);
    }

    @Test
    void 투입된_금액대비_수익률_계산() {
        assertThat(WinningsCalculator.calculateYield(1000, 5000)).isEqualTo(5);
        assertThat(WinningsCalculator.calculateYield(14000, 5000)).isEqualTo((double) 5000 / 14000);
    }
}
