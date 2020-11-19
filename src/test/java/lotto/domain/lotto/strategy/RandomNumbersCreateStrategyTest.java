package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RandomNumbersCreateStrategyTest {
    @Test
    void create() {
        // given
        final LottoNumbersCreateStrategy strategy = new RandomNumbersCreateStrategy();
        final int lottoNumberLength = LottoTicket.LOTTO_NUMBERS_LENGTH;

        // when
        final List<LottoNumber> lottoNumbers = strategy.create();

        // then
        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers.size()).isEqualTo(lottoNumberLength);
    }
}