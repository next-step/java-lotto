package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    @Test
    @DisplayName("로또 총 갯수 테스트")
    void lottoCount() {
        //given
        int buyAmount = 14000;
        int passiveLottoCount = 0;

        // when
        LottoStore lottoStore = new LottoStore(buyAmount, passiveLottoCount);
        Lottos lottos = lottoStore.buyAuto();

        //then
        Assertions.assertThat(lottos.getLottos()).hasSize(14);

    }

    @Test
    @DisplayName("로또 수동,자돋 갯수 테스트")
    void lottoCountAutoPassive() {
        //given
        int buyAmount = 14000;
        int passiveLottoCount = 4;

        // when
        LottoStore lottoStore = new LottoStore(buyAmount, passiveLottoCount);

        //then
        Assertions.assertThat(lottoStore.getAutoCount()).isEqualTo(10);
        Assertions.assertThat(lottoStore.getPassiveCount()).isEqualTo(4);
    }
}
