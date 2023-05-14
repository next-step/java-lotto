package lottoauto.domain;

import java.util.List;
import lottoauto.LottoFixture;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;
import lottoauto.model.WinningLotto;
import lottoauto.model.WinningReward;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 당첨번호_구매번호_비교_테스트() {
        Lottos lottos = LottoFixture.lottosFixture(3, 4, 6, 11, 22, 44);
        int bonusNumber = 33;
        List<Integer> winningNumber = LottoFixture.intsFixture();

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoService lottoService = new LottoService();
        LottoResult lottoResult = lottoService.compareWinningLottoNumber(lottos, winningLotto);

        Assertions.assertThat(lottoResult.getMatchCount().get(0)).isEqualTo(WinningReward.MATCH_3);
    }
}
