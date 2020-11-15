package lotto.domain.lotto;

import lotto.domain.lotto.CreateLottoNumbersStrategy;
import lotto.domain.lotto.CreateRandomNumbersStrategy;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CreateRandomNumbersStrategyTest {

    @Test
    void create() {
        // given
        final CreateLottoNumbersStrategy strategy = new CreateRandomNumbersStrategy();
        final int lottoNumberLength = Lotto.getLottoNumbersLength();

        // when
        final List<LottoNumber> lottoNumbers = strategy.create();

        // then
        assertThat(lottoNumbers).isNotEmpty();
        assertThat(lottoNumbers.size()).isEqualTo(lottoNumberLength);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}