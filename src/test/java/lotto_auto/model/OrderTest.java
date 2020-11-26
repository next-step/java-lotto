package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @DisplayName("로또 주문 유효성검사 예외 발생 테스트")
    @Test
    public void orderLottoExceptionTest() {
        assertThatThrownBy(() -> {
            List<LottoNumbers> list = new ArrayList<>();
            list.add(LottoNumbers.generate());
            list.add(LottoNumbers.generate());
            list.add(LottoNumbers.generate());
            Order order = new Order(10, 5, list, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 수동 번호가 널 일때 예외 발생 테스트")
    @Test
    public void lottoManualNumberIsNullExceptionTest() {
        assertThatThrownBy(() -> {
            Order order = new Order(10, 5, null, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
