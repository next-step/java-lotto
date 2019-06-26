package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OrderTest {

    @Test
    @DisplayName("주문 가능 수량")
    void getAvailableNumberToBuy() {
        Order order = new Order(14000);
        assertThat(order.autoPickCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매 불가 예외처리")
    void minimumOrderException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Order(900);
        });
    }

    @Test
    @DisplayName("수동 구매 초과 예외처리")
    public void tooManyHandPick() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Order(1000, 2);
        });
    }

    @Test
    @DisplayName("자동으로 생성할 개수")
    public void autoPickNumber() {
        Order order = new Order(2000, 1);
        assertThat(order.autoPickCount()).isEqualTo(1);
    }
}