package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.step2.domain.Fixture.lottoStrategyFake;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("구매 금액에 따른 로또 구매 목록 생성(10000원 => 10개)")
    void createLottos() {
        Lottos lottos = new Lottos(lottoStrategyFake, new LottoCount(1000));
        assertThat(lottos.getLottos().size()).isEqualTo(1);
    }
}