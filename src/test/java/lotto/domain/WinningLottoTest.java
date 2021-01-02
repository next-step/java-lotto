package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void create() {
        List<Integer> lotto = Arrays.asList(1,2,3,4,5,6);
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        assertThat(winningLotto).isEqualTo(new WinningLotto(lotto, 7));
    }

    @Test
    void winningLotto_invalid() {
        assertThatThrownBy(() -> {
            new WinningLotto(Arrays.asList(1,2,3,4,5,6), 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
