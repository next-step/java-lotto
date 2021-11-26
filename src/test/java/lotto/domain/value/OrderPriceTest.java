package lotto.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderPriceTest {

    @Test
    @DisplayName("가격 생성 테스트")
    void createTest() {
        OrderPrice orderPrice = new OrderPrice(3000);

        assertThat(orderPrice.getLottoPrice()).isEqualTo(3000);
    }

    @Test
    @DisplayName("가격 예외 검증")
    void exceptionTest() {

        assertThatThrownBy(() ->
                new OrderPrice(500)).isInstanceOf(IllegalArgumentException.class);
    }
}
