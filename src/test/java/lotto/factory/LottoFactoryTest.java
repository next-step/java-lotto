package lotto.factory;

import lotto.domain.Lotto;
import lotto.strategy.LottoNumbersRandomStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void make() {
        Lotto lotto = LottoFactory.make(new LottoNumbersRandomStrategy());
        assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
