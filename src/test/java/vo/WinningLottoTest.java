package vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void match_first() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto lotto = new WinningLotto(userLotto);
        assertThat(lotto.match(userLotto)).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    public void match_second() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 7);
        Lotto winningLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto lotto = new WinningLotto(winningLotto);
        assertThat(lotto.match(userLotto)).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    public void match_miss() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 7);
        Lotto winningLotto = Lotto.of(1, 2, 8, 9, 10, 11);
        WinningLotto lotto = new WinningLotto(winningLotto);
        assertThat(lotto.match(userLotto)).isEqualTo(Rank.FAILURE);
    }
}