package lotto.factory;

import lotto.domain.Lotto;
import lotto.strategy.LottoNumberRandomStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void make() {
        Lotto lotto = LottoFactory.make(new LottoNumberRandomStrategy());
        assertThat(lotto).isInstanceOf(Lotto.class);
    }
}