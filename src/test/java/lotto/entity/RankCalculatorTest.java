package lotto.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculatorTest {

    @Test
    void 합계_검증() {
        List<WinningResult> winningResults = Arrays.asList(
                new WinningResult(Rank.FOURTH, 3),
                new WinningResult(Rank.THIRD, 1)
        );

        BigDecimal result = RankCalculator.sum(winningResults);

        BigDecimal forth = BigDecimal.valueOf(55_000).multiply(BigDecimal.valueOf(3));
        BigDecimal third = BigDecimal.valueOf(1_500_000);
        assertThat(result).isEqualTo(forth.add(third));
    }

    @Test
    void 수익률_검증() {
        BigDecimal calculateRate = RankCalculator.calculateRate(3000, BigDecimal.valueOf(15000));

        assertThat(calculateRate).isEqualTo(new BigDecimal("5.00"));
    }
}
