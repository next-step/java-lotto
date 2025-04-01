package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void createTest() {
        assertThat(new Money(1000)).isEqualTo(new Money(1000));
    }

    @Test
    void divideTest() {
        Money money = new Money(1000);

        assertThat(money.divide(new Money(500))).isEqualTo(2);
    }

    @Test
    void invalidDivideTest() {
        assertThatThrownBy(() -> new Money(1000).divide(new Money(0))).isInstanceOf(ArithmeticException.class)
                .hasMessage("Cannot divide by zero");
    }

    @Test
    void greaterThanTest() {
        Money money = new Money(999);

        assertAll(() -> assertThat(money.greaterThan(new Money(998))).isTrue(),
                () -> assertThat(money.greaterThan(new Money(1000))).isFalse());
    }
}
