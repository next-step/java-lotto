package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto
                (new Lotto(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    public void match_1등() {
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void match_2등() {
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 7);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void match_3등() {
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 8);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    public void match_꽝() {
        Lotto userLotto = new Lotto(1, 2, 8, 9, 10, 11);
        assertThat(winningLotto.match(userLotto)).isEqualTo(Rank.NO_MATCH);
    }

    @Test
    public void create_보너스볼_포함() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto
                    (new Lotto(1, 2, 3, 4, 5, 6), 6);
        });
    }
}
