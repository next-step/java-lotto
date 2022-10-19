package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void test() {
        WinningLotto winningLotto = WinningLotto.of(List.of(1,2,3,4,5,6), 7);
        assertThat(winningLotto).isEqualTo(WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7));
    }
}
