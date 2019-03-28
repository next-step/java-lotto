package domain;

import org.junit.Test;
import util.WinType;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 당첨타입_확인() {
        WinningLotto winningLotto = new WinningLotto(Numbers.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = Lotto.of(Numbers.of(1, 2, 3, 4, 5, 7));

        assertThat(winningLotto.figure(lotto.getNumbers())).isEqualTo(WinType.SECOND);
    }
}
