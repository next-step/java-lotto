package lotto.entity;

import lotto.dto.ResultDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeMoneyCalculatorTest {

    @Test
    void 합계_검증() {
        List<WinningResult> winningResults = Arrays.asList(
                new WinningResult(PrizeMoney.THREE, 3),
                new WinningResult(PrizeMoney.FOUR, 1)
        );

        BigDecimal result = PrizeMoneyCalculator.sum(winningResults);

        assertThat(result).isEqualTo(BigDecimal.valueOf(65000));
    }

    @Test
    void 수익률_검증() {
        BigDecimal calculateRate = PrizeMoneyCalculator.calculateRate(3000, BigDecimal.valueOf(15000));

        assertThat(calculateRate).isEqualTo(new BigDecimal("5.00"));
    }
}
