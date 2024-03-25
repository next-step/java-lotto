package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @Test
    @DisplayName("구입한 금액으로 계산된 갯수 만큼 생성 확인")
    void calculateCount(){
        LottoStore lottoStore = new LottoStore();
        Lotto lotto1 = lottoStore.buyAutoLotto(3000);
        Lotto lotto2 = lottoStore.buyAutoLotto(5000);
        Lotto lotto3 = lottoStore.buyAutoLotto(7000);

        assertThat(lotto1.lotto().size()).isEqualTo(3);
        assertThat(lotto2.lotto().size()).isEqualTo(5);
        assertThat(lotto3.lotto().size()).isEqualTo(7);
    }
}