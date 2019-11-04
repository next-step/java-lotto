package com.seok2.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    static Stream<Arguments> moreThanOrEquals() {
        return Stream.of(
                Arguments.of(Money.of(1_000), Money.of(1_000), true),
                Arguments.of(Money.of(2_000), Money.of(1_000), true),
                Arguments.of(Money.of(0), Money.of(1_000), false)
        );
    }

    static Stream<Arguments> minus() {
        return Stream.of(
                Arguments.of(Money.of(1_000), Money.of(1_000), Money.of(0)),
                Arguments.of(Money.of(2_000), Money.of(1_000), Money.of(1_000))
        );
    }

    @ParameterizedTest
    @MethodSource("moreThanOrEquals")
    void moreThanOrEquals(Money m1, Money m2, boolean expected) {
        assertThat(m1.moreThanOrEquals(m2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minus")
    void minus(Money m1, Money m2, Money expected) {
        assertThat(m1.minus(m2)).isEqualTo(expected);
    }
}