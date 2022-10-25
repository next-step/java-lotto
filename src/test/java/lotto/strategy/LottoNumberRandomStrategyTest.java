package lotto.strategy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberRandomStrategyTest {

    @Test
    void generate() {
        LottoNumberStrategy strategy = new LottoNumberRandomStrategy();
        assertThat(strategy.generate()).isBetween(new LottoNumber(1), new LottoNumber(45));
    }
}
