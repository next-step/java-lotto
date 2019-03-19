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
        LottoGame lottoGame = new LottoGame();
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < 6 ; i++) {
            luckyNumbers.add(0);
        }
        Lotto luckyLotto = new Lotto(luckyNumbers);

        LottoResult lottoResult = lottoGame.checkLuckyCount(luckyLotto);
        int[] matchCount = lottoResult.checkResult();
        for (int i = 3; i <= 6 ; i++) {
            System.out.println(matchCount[i]);
            assertThat(matchCount[i]).isEqualTo(0);
        }
    }
}
