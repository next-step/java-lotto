package lotto.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    private WinningLotto winningLotto;

    @Before
    public void setup() {
        winningLotto = WinningLotto.from(
            Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
    }

    @Test
    public void 생성() {
        assertThat(winningLotto).isEqualTo(
            WinningLotto.from(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7)));
    }

    @Test
    public void 일등() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 이등() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 오등() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 10, 20, 30));
        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.FIFTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호와_보너스번호_중복() {
        WinningLotto.from(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(6));
    }
}