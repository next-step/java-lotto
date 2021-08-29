package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("당첨번호 와 보너스 번호 중복체크")
    void create() {
        assertThatThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1등을 반환하는지 확인")
    void first() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        Rank rank = winningLotto.matchedRank(lotto);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 + 보너스를 반환하는지 확인")
    void second_bonus() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        Rank rank = winningLotto.matchedRank(lotto);
        assertThat(rank).isEqualTo(Rank.SECOND_BONUS);
    }

    @Test
    @DisplayName("2등을 반환하는지 확인")
    void second() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,9));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        Rank rank = winningLotto.matchedRank(lotto);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등을 반환하는지 확인")
    void third() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,11,12));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        Rank rank = winningLotto.matchedRank(lotto);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등을 반환하는지 확인")
    void four() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,11,12,13));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        Rank rank = winningLotto.matchedRank(lotto);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("MISS 반환하는지 확인")
    void miss() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,11,12,13,14));
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 8);
        Rank rank = winningLotto.matchedRank(lotto);
        assertThat(rank).isEqualTo(Rank.MISS);
    }
}