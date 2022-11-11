package step2_pobi.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void invalid() {
        assertThatThrownBy(() -> {
            new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNo = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNo);
        assertThat(winningLotto).isEqualTo(new WinningLotto(lotto, bonusNo));
    }
}
