package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 10), 20);
        assertThat(winningLotto).isEqualTo(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 10), 20));
    }

    @Test
    void 당첨로또_비교_1등() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 20);
        assertThat(winningLotto.match(1, 2, 3, 4, 5, 6)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 당첨로또와_비교_2등() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);
        assertThat(winningLotto.match(1, 2, 3, 4, 5, 10)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 당첨로또_비교_3등() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 20);
        assertThat(winningLotto.match(1, 2, 3, 4, 5, 10)).isEqualTo(LottoRank.THIRD);
    }
}
