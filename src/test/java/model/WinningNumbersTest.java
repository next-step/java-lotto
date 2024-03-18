package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @Test
    void 당첨_번호_개수가_6개초과하면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 당첨_번호_개수가_6개미만이면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 숫자를_포함하고_있으면_true를_반환한다(final int number) {
        // given
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber lottoNumber = new LottoNumber(number);

        // when
        final boolean contains = winningNumbers.contains(lottoNumber);

        // then
        assertThat(contains).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 8, 10})
    void 숫자를_포함하고_있지_않으면_false를_반환한다(final int number) {
        // given
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber lottoNumber = new LottoNumber(number);

        // when
        final boolean contains = winningNumbers.contains(lottoNumber);

        // then
        assertThat(contains).isFalse();
    }
}



