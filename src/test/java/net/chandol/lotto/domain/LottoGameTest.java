package net.chandol.lotto.domain;

import net.chandol.lotto.dto.PurchaseRequest;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static net.chandol.lotto.value.Money.of;
import static org.assertj.core.api.Assertions.assertThat;


public class LottoGameTest {

    @Test
    public void 로또구매테스트() {
        LottoGame lottoGame = new LottoGame(new PurchaseRequest(of(10000), emptyList()));

        // 구매한 로또를 반환합니다.
        List<Lotto> lottos = lottoGame.getLottos();

        assertThat(lottos).hasSize(10);
    }
}