package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void createMoney_success() {
        // given
        int inputMoney = 1000;

        // when
        Money money = new Money(inputMoney);

        // then
        assertThat(money.getMoney()).isEqualTo(1000);
    }

    @Test
    void how_many_x_can_be_bought_with_this_money() {
        // given
        int inputMoney = 10000;
        int unitPrice = 1000;
        Money money = new Money(inputMoney);

        // when
        int howMany = money.countCanBuy(unitPrice);

        // then
        assertThat(howMany).isEqualTo(10);
    }

    @Test
    void how_many_x_can_be_bought_when_unit_price_is_0() {
        // given
        int inputMoney = 10000;
        int unitPrice = 0;
        Money money = new Money(inputMoney);

        // when
        int howMany = money.countCanBuy(unitPrice);

        // then
        assertThat(howMany).isEqualTo(0);
    }

}