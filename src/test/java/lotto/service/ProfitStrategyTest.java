package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.impl.RandomNumberPicker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProfitStrategyTest {

    @Test
    void shouldCalculateProfit(){
        ProfitStrategy profitStrategy = new ProfitStrategy();
        float profit = profitStrategy.calculate(new Lottos(2, () -> List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThat(profit).isEqualTo(1f);
    }
}