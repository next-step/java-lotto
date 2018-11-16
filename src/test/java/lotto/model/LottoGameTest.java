package lotto.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    int totalPrice;

    @Before
    public void setup() {
        totalPrice = 10000;
    }

    @Test
    public void 로또_게임_구입() {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.createLotto(totalPrice);
        assertThat(lottos.size()).isEqualTo(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_게임_1000원_미만_구입() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.createLotto(999);
    }

    @Test
    public void 로또_게임_결과() {
        // TODO 로또 구매시 번호 추출 로직을 분리 (테스트하기 어려운 코드)
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.createLotto(totalPrice);
        Integer bonusNumber = 10;

        LottoGameResult lottoGameResult = lottoGame.getReword("1, 2, 3, 4, 5, 6", bonusNumber);
        assertThat(lottoGameResult.getResults().size()).isEqualTo(6);
        float earningsRate = lottoGameResult.earningsRate(totalPrice);

    }
}
