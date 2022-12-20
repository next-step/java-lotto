package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningLotto;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {

    @Test
    @DisplayName("구매 로또 등수 확인 테스트")
    public void scoreTest() {
        Lotto lottoOne = new Lotto(new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto lottoTwo = new Lotto(new Integer[]{11, 21, 32, 42, 22, 23});
        Lotto lottoThree = new Lotto(new Integer[]{13, 23, 33, 43, 4, 6});

        Lottos buyLottos = new Lottos(Arrays.asList(lottoOne, lottoTwo, lottoThree));
        Lotto winLotto = new Lotto(new Integer[]{1, 4, 5, 12, 16, 24});

        WinningLotto winningLotto = new WinningLotto(buyLottos, winLotto);
        winningLotto.match();

        assertThat(winningLotto.getGradeCount(5)).isEqualTo(1);
    }

    @Test
    @DisplayName("")
    public void revenueTest() {
        Lotto lottoOne = new Lotto(new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto lottoTwo = new Lotto(new Integer[]{11, 21, 32, 42, 22, 23});
        Lotto lottoThree = new Lotto(new Integer[]{13, 23, 33, 43, 4, 6});

        Lottos buyLottos = new Lottos(Arrays.asList(lottoOne, lottoTwo, lottoThree));
        Lotto winLotto = new Lotto(new Integer[]{1, 2, 3, 4, 5, 9});

        WinningLotto winningLotto = new WinningLotto(buyLottos, winLotto);
        winningLotto.match();

        assertThat(winningLotto.getRevenue()).isEqualTo(500);
    }
}
