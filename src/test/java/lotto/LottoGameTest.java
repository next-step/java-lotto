package lotto;

import lotto.domain.LuckyLotto;
import lotto.domain.MatchLotto;
import lotto.domain.MyLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 로또구매하기() {
        LottoGame lottoGame = new LottoGame();
        int money = 4000;
        List<MyLotto> myLottos = lottoGame.buy(money);

        assertThat(myLottos.size()).isEqualTo(4);
    }

    @Test
    public void 일치개수_구하기() {

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            luckyNumbers.add(i + 1);
        }
        LuckyLotto luckyLotto = new LuckyLotto(luckyNumbers, 7);

        List<MyLotto> myLottos = new ArrayList<>();
        myLottos.add(new MyLotto(luckyNumbers));
        LottoGame lottoGame = new LottoGame(myLottos);

        LottoResult lottoResult = lottoGame.checkLuckyCount(luckyLotto);
        MatchLotto matchLotto = lottoResult.checkResult();
        assertThat(matchLotto.getMatchCounts()[6]).isEqualTo(1);
    }
}
