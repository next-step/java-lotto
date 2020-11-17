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
        final int lottoNumberLength = LottoTicket.getLottoNumbersLength();

        // when
        final List<LottoNumber> lottoNumbers = strategy.create(LottoNumber.MAX);

        // then
        assertThat(lottoNumbers).isNotEmpty();
        assertThat(lottoNumbers.size()).isEqualTo(lottoNumberLength);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}