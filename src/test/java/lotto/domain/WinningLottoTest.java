package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto).isEqualTo(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 당첨로또와_매칭_테스트_5개() {
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.match(1, 2, 3, 4, 5, 10)).isEqualTo(5);
    }
}
