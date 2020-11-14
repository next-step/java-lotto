package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoTest {
    private final List<LottoNumber> lottoNumberOneToSix = Arrays.asList(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
    );

    @Test
    void of() {
        // given
        final CreateLottoNumbersStrategy strategy = () -> lottoNumberOneToSix;

        // when 
        final Lotto lotto = Lotto.of(strategy);

        // then
        assertThat(lotto).isNotNull();
    }

    @Test
    void of_without_strategy() {
        // when 
        final Lotto lotto = Lotto.of();

        // then
        assertThat(lotto).isNotNull();
    }

    @Test
    void countHitNumber() {
        // given
        final CreateLottoNumbersStrategy strategy = () -> lottoNumberOneToSix;

        // when 
        final Lotto lotto = Lotto.of(strategy);

        // then
        assertThat(lotto.countHitNumber(Lotto.of(lottoNumberOneToSix))).isEqualTo(6);
    }
}