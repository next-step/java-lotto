package com.seok2.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    static Stream<Arguments> ofMatches() {
        return Stream.of(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(3, Rank.FOURTH),
                Arguments.of(2, Rank.MISS),
                Arguments.of(1, Rank.MISS),
                Arguments.of(0, Rank.MISS)
        );
    }

    @ParameterizedTest
    @MethodSource("ofMatches")
    void ofMatches(int matches, Rank expected) {
        assertThat(Rank.ofMatches(matches)).isEqualTo(expected);
    }
}