package lotto.model;

import lotto.model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OrderTest {

    @Test
    @DisplayName("주문 가능 수량")
    void getAvailableNumberToBuy() {
        Order order = new Order(14000);
        assertThat(order.getAvailableNumberToBuy()).isEqualTo(14);
    }

    @Test
    @DisplayName("한개도 구매 불가 예외처리")
    void minimumOrderException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Order(900);
        });
    }
}