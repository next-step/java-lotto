package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {

    @Test
    @DisplayName("총 구매 개수 만큼 로또를 발급 한다.")
    void testCreateOrders() {
        Orders orders = new Orders(5);
        assertThat(orders.getOrders()).hasSize(5);
        assertThat(orders.getTotalOrders()).isEqualTo(5);
    }

    @Test
    @DisplayName("발급된 로또를 1장씩 화면에 출력한다.")
    void testPrintLotto() {
        List<Lotto> lottos = List.of(new Lotto(1L), new Lotto(2L));
        assertThat(new Orders(lottos).toString())
                .isEqualTo("[5, 16, 29, 34, 38, 45]\n[14, 16, 21, 25, 38, 43]\n");
    }
}
