package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.impl.RandomNumberPicker;
import lotto.service.impl.RelativeProfitStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProfitStrategyTest {

    @Test
    void shouldCalculateProfit(){
        ProfitStrategy profitStrategy = new RelativeProfitStrategy();
        float profit = profitStrategy.calculate(14000,5000);
        Assertions.assertThat(profit).isEqualTo(0.35f);
    }
}