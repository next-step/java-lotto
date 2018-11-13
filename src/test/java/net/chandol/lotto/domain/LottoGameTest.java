package net.chandol.lotto.domain;

import org.junit.Test;

import java.util.List;

import static net.chandol.lotto.domain.LottoGame.getAutoLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;


public class LottoGameTest {

    @Test
    public void 로또구매테스트() {
        LottoGame lottoGame = new LottoGame(Money.of(10000));

        // 구매한 로또를 반환합니다.
        List<Lotto> lottos = lottoGame.purchase(getAutoLottoNumbers(3));

        assertThat(lottos).hasSize(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또구매시_빈값인경우_예외반환() {
        LottoGame lottoGame = new LottoGame(Money.of(10000));

        lottoGame.purchase(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또구매시_가용금액_초과할경우_예외발생() {
        LottoGame lottoGame = new LottoGame(Money.of(1000));

        lottoGame.purchase(getAutoLottoNumbers(2));
    }

    @Test
    public void 로또구매후_가용_갯수반환() {
        LottoGame lottoGame = new LottoGame(Money.of(10000));

        lottoGame.purchase(getAutoLottoNumbers(6));

        assertThat(lottoGame.getAvailableLottoPurchaseCount()).isEqualTo(4);
    }
}