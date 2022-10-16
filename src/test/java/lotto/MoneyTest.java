package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void 더하기() {
        // given
        Money money1 = new Money(1);
        Money money2 = new Money(2);
        // when
        Money result = money1.add(money2);
        // then
        assertThat(result).isEqualTo(new Money(3));
    }

    @Test
    void 곱하기() {
        // given
        Money money1 = new Money(1);
        int count = 3;
        // when
        Money result = money1.multiplication(count);
        // then
        assertThat(result).isEqualTo(new Money(3));
    }

    @Test
    void 나누기() {
        // given
        Money money1 = new Money(1000);
        Money money2 = new Money(1000);
        // when
        int result = money1.countBy(money2);
        // then
        assertThat(result).isEqualTo(1);
    }

}
