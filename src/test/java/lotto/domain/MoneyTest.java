package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    void buyCount() {
        Money money = new Money(4000);
        assertThat(money.buyCount(1000)).isEqualTo(4);
    }

}
