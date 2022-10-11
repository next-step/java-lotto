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
                LottoResult.FirstPrize,
                LottoResult.SecondPrize,
                LottoResult.ThirdPrize,
                LottoResult.ThirdPrize))).isEqualTo(2000000000 + 1500000 + 50000 + 50000);
    }
}
