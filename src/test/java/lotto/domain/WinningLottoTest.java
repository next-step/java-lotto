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
                (Lotto.of(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    public void match_1등() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.match(userLotto)).isEqualTo(1);
    }

    @Test
    public void match_2등() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 7);
        assertThat(winningLotto.match(userLotto)).isEqualTo(2);
    }

    @Test
    public void match_3등() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 8);
        assertThat(winningLotto.match(userLotto)).isEqualTo(3);
    }

    @Test
    public void match_4등() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 7, 8);
        assertThat(winningLotto.match(userLotto)).isEqualTo(4);
    }

    @Test
    public void match_5등() {
        Lotto userLotto = Lotto.of(1, 2, 3, 7, 8, 9);
        assertThat(winningLotto.match(userLotto)).isEqualTo(5);
    }

    @Test
    public void match_꽝() {
        Lotto userLotto = Lotto.of(1, 2, 7, 8, 9, 10);
        assertThat(winningLotto.match(userLotto)).isEqualTo(0);
    }

    @Test
    public void create_보너스볼_포함() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto
                    (Lotto.of(1, 2, 3, 4, 5, 6), 6);
        });
    }
}
