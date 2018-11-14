package lotto;

import lotto.domain.BundleLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoCountManager;
import lotto.domain.LottoGame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 로또발급() {
        LottoGame lottoGame = new LottoGame();
        BundleLotto bundleLotto = new BundleLotto();
        bundleLotto.addLotto(new Lotto(new String[] {"32","38","2","4","13","6"}));
        bundleLotto = lottoGame.makeLotto(new LottoCountManager(14000, 1), bundleLotto);
        assertThat(bundleLotto.getLottos().size()).isEqualTo(14);
    }

}