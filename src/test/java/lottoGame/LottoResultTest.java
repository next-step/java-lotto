package lottoGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lottoGame.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("구매한 로또가 등수 확인 테스트")
    public void gradeTest() {
        Lotto lottoOne = new Lotto("1, 2, 3, 4, 5, 7");
        Lotto lottoTwo = new Lotto(4, 6, 23, 33, 19, 37);
        Lotto lottoThree = new Lotto("23, 24, 26, 33, 44, 11");
        Lottos buyLottos = new Lottos(Arrays.asList(lottoOne, lottoTwo, lottoThree));

        WinningLotto winLotto = new WinningLotto("1, 2, 3, 4, 5, 23", 7);
        LottoGame lottoGame = new LottoGame(buyLottos, winLotto);

        LottoResult result = lottoGame.match();
        assertThat(result.getGradeCount(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("구매한 로또 수익률 테스트")
    public void revenueTest() {
        Lotto lottoOne = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto lottoTwo = new Lotto(Arrays.asList(11, 21, 32, 42, 22, 23));
        Lotto lottoThree = new Lotto(Arrays.asList(13, 23, 33, 43, 4, 6));

        Lottos buyLottos = new Lottos(Arrays.asList(lottoOne, lottoTwo, lottoThree));
        WinningLotto winLotto = new WinningLotto("1, 3, 6, 12, 33, 23", 8);
        LottoGame winningLotto = new LottoGame(buyLottos, winLotto);

        // 5등 2개
        LottoResult result = winningLotto.match();
        assertThat(result.getRevenue()).isEqualTo(3.33);
    }

    @Test
    @DisplayName("수동 구매 테스트")
    public void manualTest() {
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(11, 21, 32, 42, 22, 23);
        List<Integer> lottoThree = Arrays.asList(13, 23, 33, 43, 4, 6);

        List<List<Integer>> manualLottos = Arrays.asList(lottoOne, lottoTwo, lottoThree);

        Lottos buyLottos = new Lottos(manualLottos, 0);
        WinningLotto winLotto = new WinningLotto("1, 3, 6, 12, 33, 23", 8);
        LottoGame winningLotto = new LottoGame(buyLottos, winLotto);

        // 5등 2개
        LottoResult result = winningLotto.match();
        assertThat(result.getRevenue()).isEqualTo(3.33);
    }
}
