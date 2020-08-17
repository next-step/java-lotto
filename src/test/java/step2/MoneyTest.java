package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void constructor() {
        assertThat(new Money(0)).isEqualTo(new Money(0));
    }

    @Test
    void toInt() {
        assertThat(new Money(0).toInt()).isEqualTo(0);
    }

    @Test
    void spend() {
        Money money = new Money(1000);
        money.subtraction(1000);
        assertThat(money.toInt()).isEqualTo(0);
    }

    @Test
    void getQuantityOfItems() {
        Money money = new Money(1000);
        assertThat(money.getQuantityOfItems(1000)).isEqualTo(1);
        assertThat(money.getQuantityOfItems(1001)).isEqualTo(0);
    }
}
