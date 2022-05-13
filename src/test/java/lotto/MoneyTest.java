package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void returnTrueIfEarnMoney() {
        assertThat(new Money(4000).didEarn(5000)).isEqualTo("📈Earned!");
    }
}
