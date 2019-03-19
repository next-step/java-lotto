package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 로또구매하기() {
        LottoGame lottoGame = new LottoGame();
        int money = 4000;
        List<Lotto> lottos = lottoGame.buy(money);

        assertThat(lottos.size()).isEqualTo(4);
    }

    @Test
    public void 일치개수_구하기() {

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            luckyNumbers.add(i + 1);
        }
        Lotto lotto = new Lotto(luckyNumbers);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        LottoGame lottoGame = new LottoGame(lottos);

        LottoResult lottoResult = lottoGame.checkLuckyCount(lotto);
        int[] matchCount = lottoResult.checkResult();
        assertThat(matchCount[6]).isEqualTo(1);
    }
}
