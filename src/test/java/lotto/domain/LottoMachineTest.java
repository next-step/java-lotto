package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("가격에 맞는 개수의 로또를 반환하는지 테스트")
    void buyLottoTest() {
        int purchaseCount = 10;
        LottoMachine lottoMachine = new LottoMachine();
        LottoWrapper lottoWrapper = lottoMachine.buyLotto(Config.LOTTO_PRICE * purchaseCount, 0, Collections.EMPTY_LIST);
        assertThat(lottoWrapper.getLottos()).hasSize(purchaseCount);
    }
}