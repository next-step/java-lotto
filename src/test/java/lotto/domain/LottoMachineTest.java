package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("가격에 맞는 개수의 로또를 반환하는지 테스트")
    void buyLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoWrapper lottoWrapper = lottoMachine.buyLotto(Config.LOTTO_PRICE * 10, 0, Collections.EMPTY_LIST);
        assertThat(lottoWrapper.getLottos()).hasSize(10);
    }
}