package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void 가진_금액에서_구매_가능_갯수_확인() {
        Money money = new Money(14000);
        assertThat(money.calculateMaxQuantity()).isEqualTo(14);
    }

    @Test
    void 금액_차감() {
        Money money = new Money(14000);
        money.minus(new Money(10000));

        assertThat(money).isEqualTo(new Money(4000));
    }
}
