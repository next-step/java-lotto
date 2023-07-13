package lotto.domain.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.LottoGroup;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(LottoGroup.getQuantity(new Money(14000L)))
            .isEqualTo(new Quantity(14));
    }

    @Test
    @DisplayName("0으로 나누면 예외를 던진다.")
    void moneyDivisorShouldBePositiveNumberTest() {
        assertThrows(IllegalArgumentException.class,
            () -> new Money(10L).divide(new Money(0L)));
    }
}
