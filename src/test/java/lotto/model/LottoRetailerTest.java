package lotto.model;

import lotto.model.LottoRetailer;
import lotto.model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRetailerTest {

    @Test
    @DisplayName("수량에 따른 자동 구매")
    public void buyLottoTest() {
        Order order = new Order(2000);
        assertThat(LottoRetailer.buyAutoPick(order).size()).isEqualTo(2);
    }
}
