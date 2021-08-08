package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinLottoTest {

    @Test
    void create() {
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winLotto).isEqualTo(new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }
}