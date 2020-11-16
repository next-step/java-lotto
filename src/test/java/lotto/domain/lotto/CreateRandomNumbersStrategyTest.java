package lotto.domain.lotto;

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
        final List<LottoNumber> lottoNumbers = strategy.create(LottoNumber.MAX);

        // then
        assertThat(lottoNumbers).isNotEmpty();
        assertThat(lottoNumbers.size()).isEqualTo(lottoNumberLength);
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}