package lotto.domain;

import lotto.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void check_size() {
        assertThat(new Lotto(new RandomNumberStrategy()).getLotto()).hasSize(6);
    }

    @Test
    void check_범위() {
        Lotto lotto = new Lotto(new RandomNumberStrategy());
        for (Integer lottoNumber : lotto.getLotto()) {
            assertThat(lottoNumber).isLessThanOrEqualTo(31);
        }
    }
}