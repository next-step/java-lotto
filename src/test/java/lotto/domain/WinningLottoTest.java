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

}
