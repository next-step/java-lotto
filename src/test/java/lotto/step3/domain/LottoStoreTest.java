package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("로또 상점 생성하여 주문가격 입력")
    void getOrderCount() {
        LottoStore store = new LottoStore(14000);
        assertThat(store.getOrderPrice()).isEqualTo(new OrderPrice(14000));
    }

    @Test
    @DisplayName("총개수 = 14000 / 1000")
    void calculateAutoCount() {
        LottoStore store = new LottoStore(14000);
        assertThat(store.calculateAllCount()).isEqualTo(new OrderCount(14));
    }

}