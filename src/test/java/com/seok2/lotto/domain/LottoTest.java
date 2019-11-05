package com.seok2.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    static Stream<Arguments> lotto() {
        LottoStrategy fixedLottoStrategy = () -> IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto = Lotto.generate("1,2,3,4,5,6");
        return Stream.of(
                Arguments.of(fixedLottoStrategy, lotto)
        );
    }

    static Stream<Arguments> match() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", 6),
                Arguments.of("1,2,3,4,5,6", "1,2,3,7,8,9", 3),
                Arguments.of("1,2,3,4,5,6", "10,11,12,13,14,15", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("lotto")
    void generate(LottoStrategy strategy, Lotto expected) {
        assertThat(Lotto.generate(strategy)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("match")
    void check(String lotto, String winning, Rank expected) {
        assertThat(Lotto.generate(lotto).match(Lotto.generate(winning))).isEqualTo(expected);
    }
}