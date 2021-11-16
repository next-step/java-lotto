package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StoreTest {

    @Test
    @DisplayName("주문 가격을 입력하면 가격을 계산하고 로또 컬랙션 생성")
    void getOrderCount() {
        Store store = new Store("14000");
        assertThat(store.getOrderPrice()).isEqualTo(14000);
        assertThat(store.getOrderCount()).isEqualTo(14);
        assertThat(store.getLotteries().getLotteries()).size().isEqualTo(14);
    }

    @Test
    @DisplayName("입력 주문가격이 숫자아닌값 or 개당가격(1000원) 미만 -> IllegalArgumentException")
    void checkOrderPrice() {
        assertThatThrownBy(() -> new Store("999"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Store("999"))
                .hasMessage("1장 이상 가격 입력해주세요");
        assertThatThrownBy(() -> new Store("e"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode(() -> new Store("1000"))
                .doesNotThrowAnyException();
    }

}