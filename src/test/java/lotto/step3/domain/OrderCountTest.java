package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderCountTest {

    @Test
    @DisplayName("개수를 받아서 OrderCount 객체 생성")
    void create() {
        OrderCount orderCount = new OrderCount(1);
        assertThat(orderCount).isEqualTo(new OrderCount(1));
    }

    @Test
    @DisplayName("자동로또 개수 = 전체로또 - 수동구매")
    void calculateAutoCount() {
        OrderCount manualCount = new OrderCount(3);
        assertThat(manualCount.calculateAutoCount(new OrderCount(5))).isEqualTo(2);
    }

    @Test
    @DisplayName("1개 미만 -> IllegalArgumentException")
    void validation() {
        assertThatThrownBy(() -> new OrderCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
        //정상
        assertThatCode(() -> new OrderCount(1))
                .doesNotThrowAnyException();
    }

}