package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    Lotto userLotto;

    @BeforeEach
    void init() {
        userLotto = Lotto.from("1, 2, 3, 4, 5, 6");
    }

    @Test
    void 미당첨() {
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1, 2, 11, 12, 13, 14"), new Number(44));
        assertThat(winningLotto.rank(userLotto)).isEqualTo(Rank.MISS);
    }

    @Test
    void 당첨_5등() {
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1, 2, 3, 11, 12, 13"), new Number(44));
        assertThat(winningLotto.rank(userLotto)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨_4등() {
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1, 2, 3, 4, 11, 12"), new Number(44));
        assertThat(winningLotto.rank(userLotto)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 당첨_3등() {
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1, 2, 3, 4, 5, 13"), new Number(44));
        assertThat(winningLotto.rank(userLotto)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 당첨_2등() {
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1, 2, 3, 4, 5, 13"), new Number(6));
        assertThat(winningLotto.rank(userLotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 당첨_1등() {
        WinningLotto winningLotto = new WinningLotto(Lotto.from("1, 2, 3, 4, 5, 6"), new Number(7));
        assertThat(winningLotto.rank(userLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 로또_순서_검증() {
        Lotto lotto = Lotto.from("6, 5, 4, 3, 2, 1");
        assertThat(lotto.isSorted()).isTrue();
    }

    @Test
    void 로또_숫자_중복_예외() {
        assertThatThrownBy(() ->
            Lotto.from("1, 1, 2, 2, 3, 3")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_숫자_개수_미만_예외() {
        assertThatThrownBy(() ->
            Lotto.from("1, 2, 3, 4, 5")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_숫자_개수_초과_예외() {
        assertThatThrownBy(() ->
                Lotto.from("1, 2, 3, 4, 5, 6, 7")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
