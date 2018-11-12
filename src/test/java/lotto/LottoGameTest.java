package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 로또발급() {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottoList = lottoGame.makeLotto(14000);
        assertThat(lottoList.size()).isEqualTo(14);
    }

    @Test
    public void 로또발급개수() {
        LottoGame lottoGame = new LottoGame();
        int lottoCount = lottoGame.getLottoCount(14000);
        assertThat(lottoCount).isEqualTo(14);
    }
}