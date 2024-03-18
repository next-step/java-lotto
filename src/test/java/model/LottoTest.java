package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호_개수가_6개초과하면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 로또_번호_개수가_6개미만이면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void 로또_번호와_당첨_번호_일치하는_숫자_개수를_테스트한다() {
        // given
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 6, 7, 8, 9));

        // when
        final int matchNumberCount = lotto.findMatchNumberCount(winningNumbers);

        // then
        assertThat(matchNumberCount).isEqualTo(3);
    }
}
