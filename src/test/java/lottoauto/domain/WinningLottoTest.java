package lottoauto.domain;

import java.util.List;
import lottoauto.LottoFixture;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;
import lottoauto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 당첨번호_구매번호_비교_테스트() {
        Lottos lottos = LottoFixture.lottosFixture(3, 4, 6, 11, 22, 44);
        List<Integer> winningNumber = LottoFixture.intListFixture(1, 2, 3, 4, 6, 12);

        WinningLotto winningLotto = WinningLotto.of(lottos, winningNumber);
        LottoResult lottoResult = winningLotto.compareWinningLottoNumber();

        Assertions.assertThat(lottoResult.getMatchCount().get(0)).isEqualTo(3);
    }
}
