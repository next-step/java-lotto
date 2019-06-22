package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.LowMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @DisplayName("Money 잔액 확인")
    @ParameterizedTest
    @ValueSource(ints = {
            1_000,
            20_000,
            500_000,
            1_000_000
    })
    void should_return_balance(final int balanceValue) {
        // when
        final Money money = new Money(balanceValue);
        final Money expect = new Money(balanceValue);

        // then
        assertThat(money).isEqualTo(expect);
    }

    @DisplayName("Money 로 물건 구매 가능 여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {
            1_000,
            20_000,
            500_000,
            1_000_000
    })
    void should_return_true_when_canBuy(final int balanceValue) {
        // given
        final Money money = new Money(balanceValue);
        final Money itemPrice = new Money(balanceValue);
        final Dealable item = () -> itemPrice;

        // when
        final boolean isCanBuy = money.isCanBuy(item);

        // then
        assertThat(isCanBuy).isTrue();
    }

    @DisplayName("Money 로 물건 구매 시 잔액 차감 확인")
    @ParameterizedTest
    @CsvSource({
            "1000,100",
            "1000,1000",
            "500,500",
            "10000000,10",
    })
    void should_earn_money_when_buy_item(final int balanceValue,
                                         final int priceValue) {
        // given
        final Money money = new Money(balanceValue);
        final Money price = new Money(priceValue);

        final Dealable item = () -> price;

        // when
        money.buy(item);

        // then
        assertThat(money).isEqualTo(new Money(balanceValue - priceValue));
    }

    @DisplayName("Money 로 잔액보다 더 비싼 물건 구매 시 예외처리")
    @ParameterizedTest
    @CsvSource({
            "100,1000",
            "1000,10000",
            "500,5000",
            "1,10000000",
    })
    void should_throw_ArithmeticException_when_exceedingAmount(final int balanceValue,
                                                               final int priceValue) {
        // given
        final Money money = new Money(balanceValue);
        final Money price = new Money(priceValue);

        final Dealable item = () -> price;

        // when / then
        assertThatExceptionOfType(LowMoneyException.class)
                .isThrownBy(() -> {
                    money.buy(item);
                });
    }
}
