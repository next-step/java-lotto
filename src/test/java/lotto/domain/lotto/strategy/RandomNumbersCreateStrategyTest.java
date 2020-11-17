package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RandomNumbersCreateStrategyTest {
    @Test
    void create() {
        // given
        final LottoNumbersCreateStrategy strategy = new RandomNumbersCreateStrategy();
        final int lottoNumberLength = LottoNumbers.LOTTO_NUMBERS_LENGTH;

        // when
        final LottoNumbers lottoNumbers = strategy.create(LottoNumber.MAX);

        // then
        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers.size()).isEqualTo(lottoNumberLength);
    }
}