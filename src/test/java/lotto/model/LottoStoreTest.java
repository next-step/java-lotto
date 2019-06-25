package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test
    @DisplayName("수량에 따른 자동 구매")
    public void buyLottoTest() {
        Order order = new Order(2000, 0);
//        LottoStore lottoStore = new LottoStore(order, handPickLottos);

//        assertThat(LottoStore.buyAutoPick(order).getLottos().size()).isEqualTo(2);
    }


}
