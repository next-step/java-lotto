package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("주문 가격을 입력하면 가격을 계산하고 로또 컬랙션 생성")
    void getOrderCount() {
        LottoStore store = new LottoStore(14000);
        assertThat(store.getOrderPrice()).isEqualTo(new OrderPrice(14000));
        assertThat(store.getOrderCount()).isEqualTo(new OrderCount(14));
    }

    @Test
    @DisplayName("주문개수로 로또 묶음인 Lotteries 판매")
    void sellLotteries() {
        LottoStore store = new LottoStore(14000);
        Lotteries lotteries = store.sellLotteries();
        assertThat(lotteries.getLotteries()).size().isEqualTo(14);
    }

}