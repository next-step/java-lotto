package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("로또 객체와 보너스 번호를 전달하면 우승로또 객체를 생성한다.")
    @Test
    void winningLottoTest() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6)), 11);

        assertThat(winningLotto).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("전달받은 로또 객체와 일치하는 개수를 반환한다.")
    @Test
    void matchCountTest() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6)), 11);

        assertThat(winningLotto.matchCount(lotto)).isEqualTo(6);
    }

    @DisplayName("전달받은 로또 객체에 보너스 번호가 포함되었는지 여부를 반환한다.")
    @Test
    void matchBonusTest() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 5, 6)), 11);

        assertThat(winningLotto.matchBonus(lotto)).isFalse();
    }
}