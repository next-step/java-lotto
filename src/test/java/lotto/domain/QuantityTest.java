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
                .withMessage("수량을 초과하였습니다.Quantity{maxPurchasableQuantity=1, purchasedQuantity=2}");
    }

    @Test
    @DisplayName("구매가능 수량을 초과하면 예외가 발생한다")
    void increase() {
        Quantity quantity = new Quantity(3, 2);
        quantity = quantity.increase();
        assertThatIllegalArgumentException().isThrownBy(quantity::increase)
                .withMessage("수량을 초과하였습니다.Quantity{maxPurchasableQuantity=3, purchasedQuantity=4}");
    }

    @Test
    @DisplayName("구매가능수량 3, 구매수량 3이면 false 를 반환한다.")
    void isPurchasable() {
        Quantity quantity = new Quantity(3, 3);
        assertThat(quantity.isPurchasable()).isFalse();
    }

    @Test
    @DisplayName("최대구매가능수량은 3이다")
    void getMaxPurchasableQuantity() {
        Quantity quantity = new Quantity(3, 3);
        assertThat(quantity.getMaxPurchasableQuantity()).isEqualTo(3);
    }
}
