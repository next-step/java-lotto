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
        final Money balance = money.getBalance();
        final Money expect = new Money(balanceValue);

        // then
        assertThat(balance).isEqualTo(expect);
    }

}
