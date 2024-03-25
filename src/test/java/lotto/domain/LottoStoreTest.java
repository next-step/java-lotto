package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @Test
    @DisplayName("구입한 금액으로 계산된 갯수 만큼 생성 확인")
    void calculateCount(){
        LottoStore lottoStore = new LottoStore();
        Lottos lottos1 = lottoStore.buyAutoLotto(3000);
        Lottos lottos2 = lottoStore.buyAutoLotto(5000);
        Lottos lottos3 = lottoStore.buyAutoLotto(7000);

        assertThat(lottos1.lottos().size()).isEqualTo(3);
        assertThat(lottos2.lottos().size()).isEqualTo(5);
        assertThat(lottos3.lottos().size()).isEqualTo(7);
    }
}