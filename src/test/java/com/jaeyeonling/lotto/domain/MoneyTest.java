package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("Money 잔액 확인")
    @Test
    void should_return_balance() {
        // given
        final int balanceValue = 1000;

        // when
        final Money money = new Money(balanceValue);
        final Money expect = new Money(balanceValue);

        // then
        assertThat(money).isEqualTo(expect);
    }

    @DisplayName("Money 로 물건 구매 시 잔액 차감 확인")
    @Test
    void should_earn_money_when_buy_item() {
        // given
        final int balanceValue = 1000;
        final int priceValue = 100;

        final Money money = new Money(balanceValue);
        final Money price = new Money(priceValue);

        final Dealable item = () -> price;

        money.buy(item);

        // then
        assertThat(money).isEqualTo(new Money(balanceValue - priceValue));
    }
}
