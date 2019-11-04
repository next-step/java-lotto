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

    @ParameterizedTest
    @MethodSource("lotto")
    void generate(LottoStrategy strategy, Lotto expected) {
        assertThat(Lotto.generate(strategy)).isEqualTo(expected);
    }
}