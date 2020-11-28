package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @DisplayName("로또 수동 번호가 널 일때 예외 발생 테스트")
    @Test
    public void lottoManualNumberIsNullExceptionTest() {
        assertThatThrownBy(() -> {
            Order order = new Order(null, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
