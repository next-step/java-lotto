package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    public void score() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(7, 8, 9, 10, 11,12)))).isEqualTo(Rank.NONE);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)))).isEqualTo(Rank.NONE);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(Rank.NONE);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(Rank.FIFTH);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(Rank.FOURTH);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(1, 3, 4, 5, 6, 8)))).isEqualTo(Rank.THIRD);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.score(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(Rank.FIRST);
    }
}
