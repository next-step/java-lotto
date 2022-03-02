package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 돈_로또_가격_나누기() {
        Money money = new Money("10000");

        assertThat(money.divideToMoney()).isEqualTo(10);
    }
}