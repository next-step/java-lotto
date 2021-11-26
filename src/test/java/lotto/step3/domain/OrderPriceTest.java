package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderPriceTest {

    @Test
    @DisplayName("가격을 받아서 OrderPrice 객체 생성")
    void create() {
        OrderPrice orderPrice = new OrderPrice(14000);
        assertThat(orderPrice).isEqualTo(new OrderPrice(14000));
    }

    @Test
    @DisplayName("가격 1000원 미만 -> IllegalArgumentException")
    void validation() {
        assertThatThrownBy(() -> new OrderPrice(999))
                .isInstanceOf(IllegalArgumentException.class);
        //정상
        assertThatCode(() -> new OrderPrice(1000))
                .doesNotThrowAnyException();
    }

}
