package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

public class MoneyTest {
    @Test
    void moneyValueShouldBePositive() {
        assertThat(new Money(0)).isInstanceOf(Money.class);
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void earningRateShouldBeFiveTenth() {
        assertThat(new Money(10000).profitRate(5000)).isEqualTo(0.5);
    }

    @Test
    void investedMoneyShouldBeReserved() {
        Money origin = new  Money(5000);
        Money payed = origin.pay(1);
        assertThat(payed.hasEqualInvestedMoney(origin)).isTrue();
    }
}
