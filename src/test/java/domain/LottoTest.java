package domain;

import org.junit.Test;
import util.WinType;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void 당첨_1등() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), 7);

        WinType type = winningLotto.figure(lotto);

        assertThat(type).isEqualTo(WinType.FIRST);
    }

    @Test
    public void 당첨_2등() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 7), 6);

        WinType type = winningLotto.figure(lotto);

        assertThat(type).isEqualTo(WinType.SECOND);
    }

    @Test
    public void 당첨_3등() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 7), 10);

        WinType type = winningLotto.figure(lotto);

        assertThat(type).isEqualTo(WinType.THIRD);
    }

    @Test
    public void 당첨_4등() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 24, 7), 10);

        WinType type = winningLotto.figure(lotto);

        assertThat(type).isEqualTo(WinType.FOURTH);
    }

    @Test
    public void 당첨_5등() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 22, 24, 7), 10);

        WinType type = winningLotto.figure(lotto);

        assertThat(type).isEqualTo(WinType.FIFTH);
    }

    @Test
    public void 실패() {
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(Lotto.of(12, 2, 3, 22, 24, 7), 10);

        WinType type = winningLotto.figure(lotto);

        assertThat(type).isEqualTo(WinType.LOSE);
    }
}