package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("구입한 금액으로 계산된 갯수 만큼 생성 확인")
    void calculateCount(){
        LottoStore lottoStore = new LottoStore();
        Lotto lotto1 = lottoStore.buyAutoLotto(500);
        Lotto lotto2 = lottoStore.buyAutoLotto(1500);
        Lotto lotto3 = lottoStore.buyAutoLotto(5000);

        assertThat(lotto1.count()).isEqualTo(0);
        assertThat(lotto2.count()).isEqualTo(1);
        assertThat(lotto3.count()).isEqualTo(5);
    }
}