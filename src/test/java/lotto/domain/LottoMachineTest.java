package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("가격에 맞는 개수의 로또를 반환하는지 테스트")
    void buyLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buyLotto(Config.LOTTE_PRICE * 10);
        assertThat(lottos).hasSize(10);
    }
}