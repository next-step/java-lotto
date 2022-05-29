package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

    @Test
    void winningLotto_normal() {
        assertThat(winningLotto.matchCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
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
    void winningLotto_보너스볼숫자로또넘버와중복_argumentException() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 6));
    }
}
