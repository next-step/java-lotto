package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    @Test
    @DisplayName("구매가능 수량을 초과하면 예외가 발생한다")
    void wrongQuantityException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Quantity(1, 2))
                .withMessage("구매가능한 수량을 초과하였습니다.");
    }

    @Test
    @DisplayName("구매가능 수량을 초과하면 예외가 발생한다")
    void increase() {
        Quantity quantity = new Quantity(3, 2);
        quantity = quantity.increase();
        assertThatIllegalArgumentException().isThrownBy(quantity::increase)
                .withMessage("구매가능한 수량을 초과하였습니다.");
    }

    @Test
    @DisplayName("구매가능수량 3, 수동 구매수량 3이면 false 를 반환한다.")
    void isPurchasable() {
        Quantity quantity = new Quantity(3,3);
        assertThat(quantity.isPurchasable()).isFalse();
    }

    @Test
    @DisplayName("최대구매 가능 수량을 조회한다")
    void getMaxPurchasableQuantity() {
        Quantity quantity = new Quantity(3,0);
        assertThat(quantity.getMaxPurchasableQuantity()).isEqualTo(3);
    }

    @Test
    @DisplayName("최대구매가능수량 3, 수동구매수량 2이면 구매가능여부는 True 이다")
    void isPurchasableTrue() {
        Quantity quantity = new Quantity(3,2);
        assertThat(quantity.isPurchasable()).isTrue();
    }

    @Test
    @DisplayName("최대구매가능수량 3, 수동구매수량 3이면 구매가능여부는 False 이다")
    void isPurchasableFalse() {
        Quantity quantity = new Quantity(3,3);
        assertThat(quantity.isPurchasable()).isFalse();
    }
}
