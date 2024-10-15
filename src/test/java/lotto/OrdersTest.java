package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {

    @Test
    @DisplayName("총 구매 개수 만큼 로또를 발급 한다.")
    void testCreateOrders() {
        Orders orders = new Orders(5);
        assertThat(orders.getLOrders()).hasSize(5);
    }
}
