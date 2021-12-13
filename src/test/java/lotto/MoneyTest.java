package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void createMoney_success() {
        // given
        int inputMoney = 1000;

        // when
        Money money = new Money(inputMoney);

        // then
        assertThat(money.getMoney()).isEqualTo(new BigDecimal(1000));
    }

    @Test
    void how_many_x_can_be_bought_with_this_money() {
        // given
        Money inputMoney = new Money(10000);
        Money unitPrice = new Money(1000);

        // when
        long howMany = inputMoney.countCanBuy(unitPrice);

        // then
        assertThat(howMany).isEqualTo(10);
    }

    @Test
    void how_many_x_can_be_bought_when_unit_price_is_0() {
        // given
        Money inputMoney = new Money(10000);
        Money unitPrice = new Money(0);

        // when
        long howMany = inputMoney.countCanBuy(unitPrice);

        // then
        assertThat(howMany).isEqualTo(0);
    }

    @Test
    void calculateProfit_high() {
        // given
        Money originalMoney = new Money(10000);
        Money laterMoney = new Money(30000);

        // when
        BigDecimal profit = laterMoney.calculateProfit(originalMoney);

        // then
        assertThat(profit).isEqualTo(new BigDecimal("3.000"));
    }

    @Test
    void calculateProfit_low() {
        // given
        Money originalMoney = new Money(10000);
        Money laterMoney = new Money(500);

        // when
        BigDecimal profit = laterMoney.calculateProfit(originalMoney);

        // then
        assertThat(profit).isEqualTo(new BigDecimal("0.050"));
    }

}
