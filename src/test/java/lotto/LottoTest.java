package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    void getLottoRank_None() {
        Lotto lotto = new Lotto(Arrays.asList(5, 6, 7, 10, 11, 12));
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42));
        int bonusNumber = 19;

        LottoRank result = lotto.getLottoRank(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(LottoRank.NONE);
    }

    @Test
    void getLottoRank_Fifth() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42));
        int bonusNumber = 19;

        LottoRank result = lotto.getLottoRank(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void getLottoRank_First() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        int bonusNumber = 19;

        LottoRank result = lotto.getLottoRank(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void getLottoRank_Second() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 19));
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        int bonusNumber = 19;

        LottoRank result = lotto.getLottoRank(winningNumbers, bonusNumber);

        assertThat(result).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 중복되는_로또번호면_예외를_던진다() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_6개초과되면_예외를_던진다() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 3, 4, 5, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
