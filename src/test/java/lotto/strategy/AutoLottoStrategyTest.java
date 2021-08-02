package lotto.strategy;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutoLottoStrategyTest {
    private LottoRuleStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = AutoLottoStrategy.getInstance();
    }

    @Test
    @DisplayName("자동 로또를 한장 생성한다")
    void ticketing() {
        Lotto lotto = strategy.ticketing();
        Assertions.assertThat(lotto).isNotNull();
        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
