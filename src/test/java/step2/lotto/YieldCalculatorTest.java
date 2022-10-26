package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class YieldCalculatorTest {

    @Test
    void 수익률을_계산할_수_있다() {
        YieldCalculator yieldCalculator = new YieldCalculator(1000, List.of(Rank.FOURTH));

        assertThat(yieldCalculator.yield()).isEqualTo(5.0);
    }

}
