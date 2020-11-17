package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RandomNumberCreateStrategyTest {
    @Test
    void create() {
        // given
        final RandomNumberCreateStrategy strategy = new RandomNumberCreateStrategy();

        // when
        final LottoNumber lottoNumber = strategy.create();

        // then
        assertThat(lottoNumber).isNotNull();
        assertThat(lottoNumber.getValue()).isBetween(LottoNumber.MIN.getValue(), LottoNumber.MAX.getValue());
    }
}