package lotto.service;

import lotto.service.impl.RelativeProfitStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitStrategyTest {

    @Test
    void shouldCalculateProfit() {
        ProfitStrategy profitStrategy = new RelativeProfitStrategy();

        assertThat(profitStrategy.calculate(14000, 5000)).isEqualTo((5000f / 14000f));
    }
}
