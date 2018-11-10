package net.chandol.lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGameTest {

    @Test
    public void 로또구매테스트() {
        // 구매한 로또를 반환합니다.
        List<Lotto> lottos = LottoGame.buy(10000);
        assertThat(lottos).hasSize(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 금액은음수가될수없다() {
        LottoGame.buy(-1000);
    }

}