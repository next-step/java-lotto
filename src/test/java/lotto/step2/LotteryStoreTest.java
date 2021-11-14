package lotto.step2;

import lotto.step2.domain.LotteryStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStoreTest {

    @Test
    @DisplayName("주문 가격을 입력하면 몇개의 복권을 주는가?")
    void getOrderCount() {
        LotteryStore store = new LotteryStore(14000);
        assertThat(store.getOrderCount()).isEqualTo(14);
    }


}