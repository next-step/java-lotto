package lotto.domain.value;

import lotto.domain.value.OrderPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderPriceTest {

    @Test
    @DisplayName("가격 생성 테스트")
    void createTest() {
        OrderPrice orderPrice = OrderPrice.from(3000);

        assertThat(orderPrice.getOrderPrice()).isEqualTo(3000);
    }

    @Test
    @DisplayName("가격 예외 검증")
    void exceptionTest() {

        assertThatThrownBy(() ->
                OrderPrice.from(500)).isInstanceOf(IllegalArgumentException.class);
    }
}
