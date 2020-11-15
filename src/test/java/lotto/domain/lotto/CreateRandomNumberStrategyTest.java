package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CreateRandomNumberStrategyTest {
    @Test
    void create() {
        // given
        final CreateRandomNumberStrategy strategy = new CreateRandomNumberStrategy();

        // when
        final LottoNumber lottoNumber = strategy.create();

        // then
        assertThat(lottoNumber).isNotNull();
        assertThat(lottoNumber.getValue()).isBetween(LottoNumber.MIN.getValue(), LottoNumber.MAX.getValue());
    }
}