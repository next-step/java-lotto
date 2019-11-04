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
        LottoStrategy fixedLottoStrategy = () -> IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::new).collect(Collectors.toList());
        Lotto lotto = Lotto.generate("1,2,3,4,5,6");
        return Stream.of(
                Arguments.of(fixedLottoStrategy, lotto)
        );
    }

    static Stream<Arguments> check() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", Rank.FIRST),
                Arguments.of("1,2,3,4,5,6", "1,2,3,7,8,9", Rank.FOURTH),
                Arguments.of("1,2,3,4,5,6", "10,11,12,13,14,15", Rank.MISS)
        );
    }

    @ParameterizedTest
    @MethodSource("lotto")
    void generate(LottoStrategy strategy, Lotto expected) {
        assertThat(Lotto.generate(strategy)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("check")
    void check(String lotto, String winning, Rank expected) {
        assertThat(Lotto.generate(lotto).check(Lotto.generate(winning))).isEqualTo(expected);
    }
}