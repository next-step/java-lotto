package lottoauto.domain;

import java.util.List;
import lottoauto.LottoFixture;
import lottoauto.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 당첨번호_구매번호_비교_테스트() {
        Lottos lottos = LottoFixture.lottosFixture(3, 4, 6, 11, 22, 44);
        LottoNumber bonusNumber = LottoNumber.from(33);
        List<LottoNumber> winningNumber = LottoFixture.intsFixture();

        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
        LottoResult lottoResult = winningLotto.result(lottos);

        Assertions.assertThat(lottoResult.getMatchCount().get(0)).isEqualTo(WinningReward.MATCH_3);
    }
}
