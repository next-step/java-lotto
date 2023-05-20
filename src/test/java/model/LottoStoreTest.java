package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    @Test
    @DisplayName("로또 갯수 테스트")
    void lottoCount() {
        //given
        int buyAmount = 14000;

        // when
        LottoStore lottoStore = new LottoStore();
        Lottos lottos = lottoStore.buy(buyAmount);

        //then
        Assertions.assertThat(lottos.getLottos()).hasSize(14);

    }
}
