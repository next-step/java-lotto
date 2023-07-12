package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("구입금액은 0보다 작을 수 없다.")
    void moneyShouldGreaterThanZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1000L));
    }

    @Test
    @DisplayName("구입금액으로 상품을 몇 개 살 수 있는지 테스트")
    void calculateQuantityTest() {
        assertThat(new Money(14000L).calculateQuantity(new Money(1000L)))
            .isEqualTo(14);
    }
}
