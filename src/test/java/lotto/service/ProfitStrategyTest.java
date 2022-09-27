package lotto.service;

import lotto.service.impl.RelativeProfitStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfitStrategyTest {

    @Test
    void shouldCalculateProfit(){
        ProfitStrategy profitStrategy = new RelativeProfitStrategy();
        float profit = profitStrategy.calculate(14000, 5000);
        Assertions.assertThat(profit).isEqualTo((5000f/14000f));
    }
}