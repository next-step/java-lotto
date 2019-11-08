package com.seok2.lotto.domain.common;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.lotto.domain.common.Money;
import com.seok2.lotto.domain.common.ReturnOnInvestmentRate;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MoneyTest {

    static Stream<Arguments> moreThanOrEquals() {
        return Stream.of(
            Arguments.of(Money.of(1_000), Money.of(1_000), true),
            Arguments.of(Money.of(2_000), Money.of(1_000), true),
            Arguments.of(Money.of(0), Money.of(1_000), false)
        );
    }

    static Stream<Arguments> add() {
        return Stream.of(
            Arguments.of(Money.of(1_000), Money.of(1_000), Money.of(2_000)),
            Arguments.of(Money.of(2_000), Money.of(1_000), Money.of(3_000))
        );
    }

    static Stream<Arguments> minus() {
        return Stream.of(
            Arguments.of(Money.of(1_000), Money.of(1_000), Money.of(0)),
            Arguments.of(Money.of(2_000), Money.of(1_000), Money.of(1_000))
        );
    }

    static Stream<Arguments> multiply() {
        return Stream.of(
            Arguments.of(Money.of(1_000), 2l, Money.of(2_000)),
            Arguments.of(Money.of(2_000), 3l, Money.of(6_000))
        );
    }

    static Stream<Arguments> calculateReturnOnInvestmentRate() {
        return Stream.of(
            Arguments.of(Money.of(1_000), Money.of(5_000_000), ReturnOnInvestmentRate.of(new BigDecimal("5000"))),
            Arguments.of(Money.of(5_000_000), Money.of(1000), ReturnOnInvestmentRate.of(new BigDecimal("0.0002"))),
            Arguments.of(Money.of(1_000), Money.of(0), ReturnOnInvestmentRate.of(new BigDecimal("0")))
        );
    }

    @ParameterizedTest
    @MethodSource("moreThanOrEquals")
    void moreThanOrEquals(Money m1, Money m2, boolean expected) {
        assertThat(m1.moreThanOrEquals(m2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("add")
    void add(Money m1, Money m2, Money expected) {
        assertThat(m1.add(m2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minus")
    void minus(Money m1, Money m2, Money expected) {
        assertThat(m1.subtract(m2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("multiply")
    void multiply(Money money, long multiplicand, Money expected) {
        assertThat(money.multiply(multiplicand)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("calculateReturnOnInvestmentRate")
    void calculateReturnOnInvestmentRate(Money investment , Money returnOnInvestment , ReturnOnInvestmentRate expected){
        assertThat(returnOnInvestment.calculateReturnOnInvestmentRate(investment)).isEqualTo(expected);
    }
}