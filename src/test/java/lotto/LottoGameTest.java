package lotto;

import lotto.model.AutoLottosGenerator;
import lotto.model.Money;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @Test
    public void buy_구입_금액_0원_수량() {
        lottoGame = new LottoGame(Money.from(0));
        assertThat(lottoGame.buy(new AutoLottosGenerator()).size()).isEqualTo(0);
    }

    @Test
    public void buy_구입_금액에_해당하는_로또_수량() {
        lottoGame = new LottoGame(Money.from(5000));
        assertThat(lottoGame.buy(new AutoLottosGenerator()).size()).isEqualTo(5);
    }
}
