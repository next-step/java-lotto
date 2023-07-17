package lotto.domain.vo;

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
    @DisplayName("0으로 나누면 예외를 던진다.")
    void moneyDivisorShouldBePositiveNumberTest() {
        assertThrows(IllegalArgumentException.class,
            () -> new Money(10L).divide(new Money(0L)));
    }
}
