package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    @Test
    void winningLotto_normal() {
        assertThat(winningLotto.getNumbers())
                .contains(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }

    @Test
    void isMatchBonus_bonusNumber있는경우_true() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.isMatchBonus(lotto)).isTrue();
    }

    @Test
    void isMatchBonus_bonusNumber없는경우_false() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.isMatchBonus(lotto)).isFalse();
    }

    @Test
    void winningLotto_숫자6개이하_argumentException() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5), 7));
    }

    @Test
    void winningLotto_숫자6개초과_argumentException() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8));
    }

    @Test
    void winningLotto_보너스볼숫자로또넘버와중복_argumentException() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
    }
}
